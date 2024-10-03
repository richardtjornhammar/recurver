# recurver
Getting started with Clojure repo.

# a Nix enviornment shell
In order to run clojure REPL in emacs as well as use [leiningen](https://leiningen.org/) the following worked
```
nix-shell -p {clojure,clojure-lsp,clj-kondo,curl,rlwrap,openjdk,less,emacsPackages.clj-deps-new,emacsPackages.parseclj,emacsPackages.flycheck-clj-kondo,emacsPackages.clj-refactor,emacsPackages.clj-decompiler,git,leiningen}
```
In order to create the "getting-started" app the following was issued
```
$ lein new app getting-started
```
testing of REPL expressions belonging to the 'core.clj' can evaluated on the fly or the entire application can be easily run from terminal
```
$ lein run
```
# Useful repositories and links
[clojars](https://clojars.org/)
[https://repo.clojars.org/](https://repo.clojars.org/)



