# Library API - Automation Training

This repository was created in order to training to automation testing practices from scratch.

This repository is only the Back End part, please check the [front repository](https://github.com/AgileTestingColombia/books-ui) in order to have all the application

## How To Deploy the application

This applications is thinking to deploy in [Heroku](https://www.heroku.com/) and uses the following environment varibles:

| Env Variable     | Description                    | Value  |
|------------------|--------------------------------|--------|
| ALLOWED_ORIGINS  | Allowed URL to consume the API |        |

**Note 1**: In order to set these environment variables in Heroku check [the documentation](https://devcenter.heroku.com/articles/config-vars)

## How To Update your fork repository

Run the following commands:

```bash
  git remote add upstream git@github.com:AgileTestingColombia/books-back.git
  git pull upstream main
```

If you have altered it, you then need to rebase it.

```bash
  git rebase upstream/main
````
