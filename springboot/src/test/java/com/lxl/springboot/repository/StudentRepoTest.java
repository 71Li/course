/**
 * @FileName: StudentRepoTest
 * @description:
 * @author: Li Xialian
 * @create: 2020-06-04 18:03
 */
package com.lxl.springboot.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
 class StudentRepoTest {
    @Autowired
    private StudentRepo studentRepo;
    @Test
    void findAll(){
        System.out.println(studentRepo.findAll());
    }



}