# Feature: SpringDoc OpenAPI Integration

## Overview
In this branch, **SpringDoc OpenAPI** has been integrated into the project to automatically generate interactive API documentation using **Swagger UI**.  
This allows developers and stakeholders to easily explore, test, and understand all available endpoints without manually writing documentation.

## Key Changes
- Added **SpringDoc OpenAPI** dependencies in `pom.xml`.
- Configured `application.properties` for Swagger UI customization.
- APIs are now automatically documented based on existing controller and model definitions.
- Swagger UI is accessible at a dedicated URL for easy testing.

## How It Works
1. **SpringDoc OpenAPI** scans all REST controllers and models at runtime.
2. It generates an **OpenAPI specification** in JSON and YAML formats.
3. **Swagger UI** renders this specification into a user-friendly, interactive interface.
4. Developers can test API endpoints directly from the browser.

## Example
- **Swagger UI URL:** http://localhost:8080/swagger-ui.html
**OpenAPI YAML specification:**  http://localhost:8080/v3/api-docs.yaml
  ## Benefits
- **Automatic Documentation:** No manual Swagger annotations required for basic setup.
- **Interactive Testing:** Try API requests directly from the browser.
- **Up-to-Date Specs:** Documentation updates automatically as endpoints change.
- **Improved Collaboration:** Makes APIs easier to understand for frontend developers, QA engineers, and third-party integrators.

## Dependencies Added
```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.5.0</version> <!-- Use latest stable version -->
</dependency>
