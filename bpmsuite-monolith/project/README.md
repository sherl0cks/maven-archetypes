# BPM Suite Monolith

This project aligns to the [BPM Suite monolith pattern](http://redhat.slides.com/jholmes/bxms-standard-project-structures#/12) and it's corresponding [maven project structure](http://redhat.slides.com/jholmes/bxms-standard-project-structures#/13).

## Notes
1. The current m2e config in JBDS requires you to run `mvn install` on the KJar each time you want to deploy a new version of your process model. This a general product thing.
2.


## Challenges
1. Elect one person on the team to create a github repo for your team. That repo can be a fork of this one, or you can copy this subtree of the project into your new repo. Up to your team. Use the repo for all collaboration, no emailing code. It will help if you [add all team members as collaborators on the repo](https://help.github.com/articles/adding-collaborators-to-a-personal-repository/)

2. Create a Customer object and use it in the process model
  1. Add the object in the Language project under a new package called com.rhc.aggregates. Aggregates come from domain driven design and are an important modelling concept. If this is a new term, please read [Martin Fowler's definition](http://martinfowler.com/bliki/DDD_Aggregate.html).
  2. Update the CustomerService to use your new customer object instead of Strings.
  3. Update the process model to use a Customer object as the process variable. Remove the two string variables
  4. Update the script task to print the message with the Customer object's toString().

3. Add an Address object, use it in the Customer, process model and task model.
  1. Add the object in the Language project under a new package called com.rhc.entities. use what ever fields you think are important. Entities come from domain driven design and are an important modelling concept. If this a new term (even if you have seen entities in JPA), please read [the definition](http://dddcommunity.org/resources/ddd_terms/).
  2. Add Address to Customer
  3. Create a human task in the process definition that will input the address information of the customer and update the object.
  4. Write a script task (or on exit script) to print the new Customer object to the console