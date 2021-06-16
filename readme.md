This project shows how the tasty inspector in Scala 3 only considers top-level
tasty files when searching jar files.

There are two projects:

1. `app` - contains and example dummy project, with one top-level class and one
   nested class, leading to two tasty files.

2. `inspector` - contains a project that invoked the tasty inspector to list
   tastys in a jar.

## Steps to reproduce the issue:

1. Build the jar file: `./mill app.jar`

2. Inspect the jar, to make sure we actually have tasty files: `jar tf out/app/jar/dest/out.jar`

   The output should look something like:

   ```
   META-INF/MANIFEST.MF
   A.class
   A.tasty
   pkg/A.class
   pkg/A.tasty
   ```

   Note that there is one "top-level" tasty file, and one under a package.

3. Run the tasty inspector project and see how many files it finds: `./mill inspector.run out/app/jar/dest/out.jar`

   It will only find the top-level tasty file.

   ```
   1
   app/src/toplevel.scala
   ```
