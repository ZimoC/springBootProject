package com.dogaozdemir.springBootProject.service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dogaozdemir.springBootProject.model.Meter;
import com.dogaozdemir.springBootProject.model.ProfileFraction;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

@Repository
public class PowerHouseService {

	@SuppressWarnings("deprecation")
	public List<ProfileFraction> getProfileFractionFromCSV() {
		CSVReader csvReader = null;
		// Map<ProfileFractionId, Double> pfMap=new HashMap<ProfileFractionId,
		// Double>();
		List<ProfileFraction> pfAll = new ArrayList<ProfileFraction>();
		try {
			/**
			 * Reading the CSV File Delimiter is comma Default Quote character
			 * is double quote Start reading from line 1
			 */
			csvReader = new CSVReader(new FileReader("profile-fraction.csv"),
					',', '"', 1);
			// mapping of columns with their positions
			ColumnPositionMappingStrategy<ProfileFraction> mappingStrategy = new ColumnPositionMappingStrategy<ProfileFraction>();
			// Set mappingStrategy type to Employee Type
			mappingStrategy.setType(ProfileFraction.class);
			// Fields in Employee Bean
			String[] columns = new String[] { "Month", "Profile", "Fraction" };
			// Setting the colums for mappingStrategy
			mappingStrategy.setColumnMapping(columns);
			// create instance for CsvToBean class
			CsvToBean<ProfileFraction> ctb = new CsvToBean<ProfileFraction>();
			// parsing csvReader(Employee.csv) with mappingStrategy
			List<ProfileFraction> pfList = ctb
					.parse(mappingStrategy, csvReader);

			for (ProfileFraction pf : pfList) {
				pfAll.add(pf);

			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			try {
				// closing the reader
				csvReader.close();

			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
		return pfAll;
	}

	@SuppressWarnings("deprecation")
	public List<Meter> getMeterFromCSV() {
		CSVReader csvReader = null;
		List<Meter> meterAll = new ArrayList<Meter>();
		try {
			/**
			 * Reading the CSV File Delimiter is comma Default Quote character
			 * is double quote Start reading from line 1
			 */
			csvReader = new CSVReader(new FileReader("Meter.csv"), ',', '"', 1);
			// mapping of columns with their positions
			ColumnPositionMappingStrategy<Meter> mappingStrategy = new ColumnPositionMappingStrategy<Meter>();
			// Set mappingStrategy type to Employee Type
			mappingStrategy.setType(Meter.class);
			// Fields in Employee Bean
			String[] columns = new String[] { "meterId", "profile", "month",
					"meterReading" };
			// Setting the colums for mappingStrategy
			mappingStrategy.setColumnMapping(columns);
			// create instance for CsvToBean class
			CsvToBean<Meter> ctb = new CsvToBean<Meter>();
			// parsing csvReader(Employee.csv) with mappingStrategy
			List<Meter> mList = ctb.parse(mappingStrategy, csvReader);
			// Print the Employee Details
			for (Meter m : mList) {

				meterAll.add(m);

			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			try {
				// closing the reader
				csvReader.close();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
		return meterAll;

	}

}
