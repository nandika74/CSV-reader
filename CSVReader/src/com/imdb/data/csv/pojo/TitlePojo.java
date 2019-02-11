/**
 * 
 */
package com.imdb.data.csv.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imdb.data.csv.pojo.parser.NumericBooleanDeserializer;
import com.imdb.data.csv.pojo.parser.NumericBooleanSerializer;
import com.imdb.data.csv.pojo.parser.StringListDeserializer;
import com.imdb.data.csv.pojo.parser.StringListSerializer;

/**
 * @author A1855
 *
 */

public class TitlePojo extends IMDBPojo {

	private final String tconst;

	/*
	 * The type/format of the title (e.g. movie, short, tvseries, tvepisode, video,
	 * etc)
	 */
	private final String titleType;

	/*
	 * The more popular title / the title used by the filmmakers on promotional
	 * materials at the point of release
	 */
	private final String primaryTitle;

	/*
	 * Original title, in the original language
	 */
	private final String originalTitle;

	/*
	 * 0: non-adult title; 1: adult title
	 */
	@JsonSerialize(using = NumericBooleanSerializer.class)
	@JsonDeserialize(using = NumericBooleanDeserializer.class)
	private Boolean isAdult;

	/*
	 * Represents the release year of a title. In the case of TV Series, it is the
	 * series start year
	 */
	private final Integer startYear;

	/*
	 * TV Series end year. ‘\N’ for all other title types
	 */
	private final Integer endYear;

	/*
	 * primary runtime of the title, in minutes
	 */
	private final Integer runtimeMinutes;

	/*
	 * Includes up to three genres associated with the title
	 */
	@JsonSerialize(using = StringListSerializer.class)
	@JsonDeserialize(using = StringListDeserializer.class)
	private final List<String> genres;

	@JsonCreator
	public TitlePojo(@JsonProperty("tconst") String tconst, @JsonProperty("titleType") String titleType,
			@JsonProperty("primaryTitle") String primaryTitle, @JsonProperty("originalTitle") String originalTitle,
			@JsonProperty("isAdult") Boolean isAdult, @JsonProperty("startYear") Integer startYear,
			@JsonProperty("endYear") Integer endYear, @JsonProperty("runtimeMinutes") Integer runtimeMinutes,
			@JsonProperty("genres") List<String> genres) {
		this.tconst = tconst;
		this.titleType = titleType;
		this.primaryTitle = primaryTitle;
		this.originalTitle = originalTitle;
		this.isAdult = isAdult;
		this.startYear = startYear;
		this.endYear = endYear;
		this.runtimeMinutes = runtimeMinutes;
		this.genres = genres;
	}

	@JsonProperty("tconst")
	public String getTconst() {
		return tconst;
	}

	@JsonProperty("titleType")
	public String getTitleType() {
		return titleType;
	}

	@JsonProperty("primaryTitle")
	public String getPrimaryTitle() {
		return primaryTitle;
	}

	@JsonProperty("originalTitle")
	public String getOriginalTitle() {
		return originalTitle;
	}

	@JsonProperty("isAdult")
	public Boolean getIsAdult() {
		return isAdult;
	}

	@JsonProperty("startYear")
	public Integer getStartYear() {
		return startYear;
	}

	@JsonProperty("endYear")
	public Integer getEndYear() {
		return endYear;
	}

	@JsonProperty("runtimeMinutes")
	public Integer getRuntimeMinutes() {
		return runtimeMinutes;
	}

	@JsonProperty("genres")
	public List<String> getGenres() {
		return genres;
	}

	@Override
	public String toString() {
		return "Pojo [tconst=" + tconst + ", titleType=" + titleType + ", primaryTitle=" + primaryTitle
				+ ", originalTitle=" + originalTitle + ", isAdult=" + isAdult + ", startYear=" + startYear
				+ ", endYear=" + endYear + ", runtimeMinutes=" + runtimeMinutes + ", genres=" + genres + "]";
	}

}
