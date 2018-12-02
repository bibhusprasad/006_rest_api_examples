package com.messanger.resources.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.messanger.resources.dataBase.DatabaseClass;
import com.messanger.resources.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService() {
		profiles.put("bibhu", new Profile(1L, "bibhu_prof", "bibhu", "samal"));
		profiles.put("alok", new Profile(2L, "alok_prof", "alok", "dash"));
		profiles.put("asu", new Profile(3L, "asu_prof", "asu", "panda"));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}

}
