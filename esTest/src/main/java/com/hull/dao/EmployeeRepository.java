package com.hull.dao;

import com.hull.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author
 * @create 2019-04-21 21:55
 **/

@Component
public interface EmployeeRepository  extends ElasticsearchRepository<Employee,String> {

    /**
     * 查询雇员信息
     * @param id
     * @return
     */
    Employee queryEmployeeById(String id);

}
