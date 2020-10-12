package com.semi.community.web;

import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;

import static org.assertj.core.api.Assertions.assertThat;


public class ProfileControllerUnitTest {

    @Test
    public void real_profile_select(){
        String expectedProfile = "real";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("oauth");
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);

        String profile = controller.profile();
        assertThat(profile).isEqualTo(expectedProfile);

    }

    @Test
    public void if_real_profile_not_exists_select_first(){
        String expectedProfile = "oauth";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);
        String profile = controller.profile();
        assertThat(profile).isEqualTo(expectedProfile);
    }


    @Test
    public void if_active_profile_not_exists_select_default(){
        String expectedProfile = "default";
        MockEnvironment env = new MockEnvironment();

        ProfileController controller = new ProfileController(env);
        String profile = controller.profile();
        assertThat(profile).isEqualTo(expectedProfile);
    }
}
