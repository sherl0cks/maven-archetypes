package com.rhc.mock.repositories;

import com.rhc.aggregates.Customer;
import com.rhc.repositories.api.CustomerStageRepository;

public class MockCustomerStageRepository extends AbstractMapCrudRepository<Customer> implements CustomerStageRepository {


}
