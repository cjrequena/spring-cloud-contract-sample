import org.springframework.cloud.contract.spec.Contract
[
Contract.make {
    description "should return even when number input is even"
    request {
        method GET()
        url("/calculator-service/validate-prime-number") {
            queryParameters {
                parameter("number", "2")
            }
        }
    }
    response {
        body("Even")
        status 200
    }
},
Contract.make {
    description "should return even when number input is even"
    request {
        method GET()
        url("/calculator-service/validate-prime-number") {
            queryParameters {
                parameter("number", "4")
            }
        }
    }
    response {
        body("Even")
        status 200
    }
},
Contract.make {
    description "should return even when number input is even"
    request {
        method GET()
        url("/calculator-service/validate-prime-number") {
            queryParameters {
                parameter("number", "6")
            }
        }
    }
    response {
        body("Even")
        status 200
    }
},
Contract.make {
    description "should return even when number input is even"
    request {
        method GET()
        url("/calculator-service/validate-prime-number") {
            queryParameters {
                parameter("number", "8")
            }
        }
    }
    response {
        body("Even")
        status 200
    }
},
Contract.make {
    description "should return even when number input is even"
    request {
        method GET()
        url("/calculator-service/validate-prime-number") {
            queryParameters {
                parameter("number", "10")
            }
        }
    }
    response {
        body("Even")
        status 200
    }
}
]
