package com.chaseit.models.wrappers;

import java.io.Serializable;

import com.chaseit.ParseHelper;
import com.chaseit.models.Location;
import com.google.android.gms.maps.model.LatLng;
import com.parse.ParseFile;

public class LocationWrapper implements Serializable {
	private static final long serialVersionUID = -8674218181201709458L;
	private ParseObjectWrapper wrapper;

	public LocationWrapper(Location location) {
		wrapper = new ParseObjectWrapper(location);
	}

	public LocationWrapper(ParseObjectWrapper locationW) {
		wrapper = locationW;
	}

	public String getObjectId() {
		return wrapper.getString(ParseHelper.OBJECTID_TAG);
	}

	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return wrapper.getString(Location.LOCATION_NAME_TAG);
	}

	/**
	 * @return the location
	 */
	public LatLng getLocation() {
		return wrapper.getLocation(Location.LOCATION_LOCATION_TAG);
	}

	/**
	 * @return the hint
	 */
	public String getHint() {
		return wrapper.getString(Location.LOCATION_HINT_TAG);
	}

	/**
	 * @return the image
	 */
	public ParseFile getImage() {
		return wrapper.getParseFile(Location.LOCATION_IMAGE_TAG);
	}

	/**
	 * @returns the parent hunt for this location
	 */
	public HuntWrapper getParentHunt() {
		return new HuntWrapper(
				wrapper.getParseObject(Location.LOCATION_PARENTHUNT_TAG));
	}

	/**
	 * @return get the index in the hunt
	 */
	public int getIndexInHunt() {
		return wrapper.getInt(Location.LOCATION_INDEX_TAG);
	}

}