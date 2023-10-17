# Email Service 

Challenge proposed by [Uber archive](https://github.com/uber-archive/coding-challenge-tools/blob/master/coding_challenge.md#email-service)

### Challenge Description
Create a service that accepts the necessary information and sends emails. It
should provide an abstraction between two different email service providers.
If one of the services goes down, your service can quickly failover to
a different provider without affecting your customers.

Chosen Email Provider:

* [Amazon SES](http://aws.amazon.com/ses/) - [Simple Send Documentation](http://docs.aws.amazon.com/ses/latest/APIReference/API_SendEmail.html)

Technical spec
--------------

The architecture will be split between a back-end and a web front-end, for
instance providing a JSON in/out RESTful API. 

Chosen Technical Track:

- **Back-end track**: include a minimal front-end (e.g. a static view or API
   docs). Write, document and test your API as if it will be used by other
   services.

### Back-end

Technologies used:

* Java
* Spring Boot

You are also free to use any web framework. If you choose to use a framework
that results in boilerplate code in the repository, please detail in your
README which code was written by you (as opposed to generated code).

### Front-end

The front-end should ideally be a single page app with a single `index.html`
linking to external JS/CSS/etc. You may take this opportunity to demonstrate
your CSS3 or HTML5 knowledge.

