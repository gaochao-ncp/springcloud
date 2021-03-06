package com.floatpoint.controller;

import com.floatpoint.commons.ServiceName;
import com.floatpoint.dto.DeptDto;
import com.floatpoint.entity.Dept;
import com.floatpoint.service.DeptServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 消费者内部是不需要service层的，直接消费提供者
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class DeptController_consumer {

  @Autowired
  private DeptServiceClient deptServiceClient;

  @GetMapping("/get/{no}")
  public Dept getByNo(@PathVariable("no") int no){
    log.info("请求前缀地址为："+ServiceName.SERVICE_NAME_8001);
    Dept dto = deptServiceClient.getByNo(no);
    return dto;
  }

  @PostMapping("/add")
  public String addDept(@RequestBody DeptDto dto){
    return deptServiceClient.addDept(dto);
  }

  @GetMapping("/delete/{no}")
  public String deleteDeptByNo(@PathVariable("no") int no){
    return deptServiceClient.deleteDeptByNo(no);
  }

}
