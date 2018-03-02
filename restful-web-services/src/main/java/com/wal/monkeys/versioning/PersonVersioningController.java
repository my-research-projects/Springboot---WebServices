package com.wal.monkeys.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	//http://localhost:8080/v1/person
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("James Wong");
	}
	
	//http://localhost:8080/v2/person
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("James", "Wong"));
	}
	
	//http://localhost:8080/person/param?version=1
	@GetMapping(value="/person/param", params="version=1")
	public PersonV1 paramV1() {
		return new PersonV1("James Wong");
	}
	//http://localhost:8080/person/param?version=2
	@GetMapping(value="/person/param", params="version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("James", "Wong"));
	}
	
	//http://localhost:8080/person/header (X-API-VERSION=1 as header specified)
	@GetMapping(value="/person/header", headers="X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("James Wong");
	}
	
	//http://localhost:8080/person/header (X-API-VERSION=2 as header specified)
	@GetMapping(value="/person/header", headers="X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("James", "Wong"));
	}

	//http://localhost:8080/person/header (application/vnd.company.app-v1+json as header specified)
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("James Wong");
	}
	
	//http://localhost:8080/person/header (application/vnd.company.app-v2+json as header specified)
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("James", "Wong"));
	}

	
}
