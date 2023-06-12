package com.example.employee;

import com.example.employee.dtoIn.TitleNameDTO;
import com.example.employee.model.TitleNameModel;
import com.example.employee.repository.TitleNameRepository;
import com.example.employee.service.TitleNameService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeApplicationTests {
    @Autowired
    private TitleNameService titleNameService;
    @Autowired
    private TitleNameRepository titleNameRepository;

    @Test
    @Transactional
    public void testSaveEmployee() {
        TitleNameDTO titleNameDTO = new TitleNameDTO();
        titleNameDTO.setTitleName("Sample Title");

        TitleNameModel savedTitleName = titleNameService.createTitleName(titleNameDTO);

        TitleNameModel retrievedTitleName = titleNameRepository.findById(savedTitleName.getId()).orElse(null);

        assertNotNull(retrievedTitleName);
        assertEquals(titleNameDTO.getTitleName(), retrievedTitleName.getTitleName());
    }

}
