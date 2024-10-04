# recurver
Getting started with Clojure repo.

# a Nix enviornment shell
In order to run clojure REPL in emacs as well as use [leiningen](https://leiningen.org/) the following worked
```
$ nix-shell -p {clojure,clojure-lsp,clj-kondo,curl,rlwrap,openjdk,less,emacsPackages.clj-deps-new,emacsPackages.parseclj,emacsPackages.flycheck-clj-kondo,emacsPackages.clj-refactor,emacsPackages.clj-decompiler,git,leiningen}
```

# Make an app via leiningen
In order to create the "getting-started" app the following was issued
```
$ lein new app getting-started
```
testing of REPL expressions belonging to the 'core.clj' can evaluated on the fly or the entire application can be easily run from terminal
```
$ lein run
```
In order to create a stand-alone java program the following works
```
$ lein uberjar
```
which creates a jar file that can be run through openjdk (java) as 
```
$  java -jar target/uberjar/getting-started-0.1.0-SNAPSHOT-standalone.jar
```

# Useful repositories and links
[clojars](https://clojars.org/)
[https://repo.clojars.org/](https://repo.clojars.org/)

[uncomplicate's numerical computation repos](https://github.com/uncomplicate)

[data wrangling](https://github.com/techascent/tech.ml.dataset)

[bioviz blog](https://blog.klipse.tech/visualization/2021/02/16/graph-playground-cytoscape.html)

