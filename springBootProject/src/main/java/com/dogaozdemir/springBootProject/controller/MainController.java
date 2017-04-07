package com.dogaozdemir.springBootProject.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogaozdemir.springBootProject.model.Meter;
import com.dogaozdemir.springBootProject.model.ProfileFraction;
import com.dogaozdemir.springBootProject.repository.MeterRepository;
import com.dogaozdemir.springBootProject.repository.ProfileFractionRepository;
import com.dogaozdemir.springBootProject.service.PowerHouseService;

@RestController
public class MainController {

	@Autowired
	ProfileFractionRepository profileFractionRepository;

	@Autowired
	PowerHouseService phService;

	@Autowired
	MeterRepository meterRepository;


	@RequestMapping("/profile-fraction")
	public List<ProfileFraction> getPF() {
		List<ProfileFraction> pfList = phService.getProfileFractionFromCSV();
		List<ProfileFraction> resultList = new ArrayList<ProfileFraction>();
		BigDecimal controlFraction = new BigDecimal(0);
		Collections.sort(pfList, new Comparator<ProfileFraction>() {
			@Override
			public int compare(final ProfileFraction object1,
					final ProfileFraction object2) {
				return object1.getProfile().compareTo(object2.getProfile());
			}
		});
		for (int i = 0; i < pfList.size() / 12; i++) {
			List<ProfileFraction> pfs = new ArrayList<ProfileFraction>();
			for (int j = 0; j <= 11; j++) {
				ProfileFraction curPF = pfList.get(j + 12 * i);
				controlFraction = controlFraction.add(new BigDecimal(curPF
						.getFraction()));
				controlFraction = controlFraction.setScale(2,
						BigDecimal.ROUND_HALF_UP);
				pfs.add(curPF);
				System.out.println(curPF.getProfile() + " - " + controlFraction);
			}
			if (controlFraction.equals(new BigDecimal("1.00")) == true) {
				profileFractionRepository.save(pfs);
				resultList.addAll(pfs);
			} else
				System.err.println("PROFILE '" + pfs.get(0).getProfile()
						+ "' FRACTION SUM IS NOT EQUAL TO 1! ERROR!");
			controlFraction = new BigDecimal(0);
			// System.out.println(pfList.get(i).toString());
		}
		return resultList;
	}

	@RequestMapping("/meter")
	public List<Meter> getMeters() {
		List<Meter> resultList = new ArrayList<Meter>();
		List<Meter> meterAll = phService.getMeterFromCSV();
		int controlMeter = 0;
		Collections.sort(meterAll, new Comparator<Meter>() {
			@Override
			public int compare(final Meter object1, final Meter object2) {
				return object1.getMeterId().compareTo(object2.getMeterId());
			}
		});

		for (int i = 0; i < meterAll.size() / 12; i++) {
			List<Meter> meters = new ArrayList<Meter>();
			for (int j = 0; j <= 11; j++) {
				Meter mt = meterAll.get(j + 12 * i);
				if (mt.getMeterReading() >= controlMeter) {
					controlMeter = mt.getMeterReading();
					meters.add(mt);
				} else {
					meters.clear();
				}

				System.out.println(mt.toString());
			}
			resultList.addAll(meters);
		}

		return resultList;
	}
}
