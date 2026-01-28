.PHONY: build preview

# Build the final merged OpenAPI yaml
build:
	cd _merged && npx openapi-merge-cli && node correction.js

# Preview the OpenAPI documentation
preview:
	cd _merged && npx @redocly/cli preview