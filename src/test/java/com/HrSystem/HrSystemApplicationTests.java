package com.HrSystem;

import com.HrSystem.entity.User;
import com.HrSystem.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = HrSystemApplication.class)
class HrSystemApplicationTests {

	@Test
	void contextLoads() {
	}
}
