# Sample project using Dagger 2 / RxJava / Retrofit

Demonstrates usage of MVP. `Presenter` is doing the network calls using *Retrofit* and *RxJava* and based on the response decides which method to invoke from the `View`.

There's also unit tests covering the `Presenter` code. We are testing all the possible responses from the network covering each success and error case.

Test cases are written with [Given-When-Then](https://en.wikipedia.org/wiki/Given-When-Then) format. For example to test 401 response code :

```
// given
when(githubService.getRepos())
        .thenReturn(Observable.<User>error(new HttpException(response401())));

// when
presenter.loadData();

// then
verify(view).showError(CODE_401_UNAUTHORIZED);
verify(view, never()).showData(user());
```


Since we use *RxJava* we have to use a specific `Rule` for our tests which ensures that our subscriptions always *subscribeOn* and *observeOn* `Schedulers.immediate()` . That specific Scheduler executes work immediately which is what we want for our tests.  
