/**
 * 
 */
package com.e2e.userManagement.persistence;

import org.springframework.data.repository.CrudRepository;

import com.e2e.userManagement.pojo.UserPojo;

/**
 * @author Aprimit Garg
 *
 */
public interface UserRepository extends CrudRepository<UserPojo, String> {

}
