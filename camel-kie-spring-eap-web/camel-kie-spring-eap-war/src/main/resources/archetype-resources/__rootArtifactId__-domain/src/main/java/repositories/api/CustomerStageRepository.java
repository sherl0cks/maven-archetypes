#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repositories.api;

import ${package}.aggregates.Customer;

public interface CustomerStageRepository extends CRUDRepository<Customer> {

}
