package com.capgemini.crudexample.Example.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

public class ExampleNotFoundException extends RuntimeException {

	 public ExampleNotFoundException(String exception) {
		    super(exception);
		  }
}
