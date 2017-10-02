# MovieListMiniApp
Electrode Native - Movie List MiniApp (Getting Started sample application)

Application that has a UI to display a list of movies.

# Run standalone
To run this app stand alone simply clone the repo and execute the ern run command as below.

```bash
$ git clone https://github.com/electrode-io/MovieListMiniApp.git
$ cd MovieListMiniApp
$ yarn install
```

#### Android

```bash
$ ern run-android
```

#### iOS

```bash
$ ern run-ios
```


# Run with MovieDetailsMiniApp.

 With react-native platform you can easily combine multiple MiniApps into a single native application.

 Here we have created a MovieDetailsMiniApp to take the user to the movie details page when a movie is clicked.
 To see how it works simply follow the steps below.

 ```bash
 $ git clone https://github.com/electrode-io/MovieListMiniApp.git
 $ cd MovieListMiniApp
 ```

#### Android

 ```bash
 $ ern run-android --miniapps moviedetailsminiapp --mainMiniAppName MovieListMiniApp
 ```

#### iOS

 ```bash
 $ ern run-ios --miniapps moviedetailsminiapp --mainMiniAppName MovieListMiniApp
 ```

Once the app is launched clicking on a movie will take you to the details page of [MovieDetailsMiniApp](https://github.com/electrode-io/MovieDetailsMiniApp)

To build this app from scratch, follow the instructions of our [Getting started guide](https://electrode.gitbooks.io/electrode-native/content/getting-started/getting-started.html)

To know more about electrode native platform check the docs [HERE](https://electrode.gitbooks.io/electrode-native/content/).