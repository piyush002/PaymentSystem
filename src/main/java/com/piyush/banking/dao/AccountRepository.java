package com.piyush.banking.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.piyush.banking.domain.Account;

/**
 * Database access object for Account table
 * 
 * @author Piyush Mittal piyush
 * @created Oct 15, 2018
 */
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {


  @Override
  public Optional<Account> findById(Long accountNumber);

  @Override
  public <S extends Account> S save(S arg0);
}
