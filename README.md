A sample repository to demonstrate a weird issue upgrading from gradle 7.3.3 to
gradle 7.5

in the following, a full build is : 
```
./gradlew build
```
a targeted build is : 
```
./gradlew :task-shell-app:build
```

Building this repository: 
- gradle 7.3.3 full build : works
- gradle 7.3.3 targeted build: works
- gradle 7.5 full build: works
- gradle 7.5 tageted build: does not work
- gradle 7.5 with `./gradlew clean :task-shell-app:build` works

