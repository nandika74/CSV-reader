package com.imdb.data.csv;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.imdb.data.csv.pojo.TitlePojo;

public class CsvHandler<T> {

	public static void main(String[] args) throws IOException {
		File csv = new File("D:\\Axiata\\workspace\\imdb\\dataset\\title.basics\\data.tsv");
		System.out.println(csv);

		CsvHandler<TitlePojo> CsvHandler = new CsvHandler<TitlePojo>();
		CsvHandler.process(TitlePojo.class, csv);
	}

	public void process(Class<?> T, File csv) throws IOException {
		CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader().withColumnSeparator('\t').withoutQuoteChar()
				.withNullValue("\\N");
		ObjectMapper mapper = new CsvMapper();
		MappingIterator<T> it = mapper.readerFor(T).with(bootstrapSchema).readValues(csv);

		System.out.println(System.currentTimeMillis());

		while (it.hasNext()) {
			T pojo = it.nextValue();
			System.out.println(pojo.toString());
		}

		// List<T> pojos = it.readAll();
		System.out.println(System.currentTimeMillis());

		// System.out.println("Counter: " + pojos.size());

	}
}
