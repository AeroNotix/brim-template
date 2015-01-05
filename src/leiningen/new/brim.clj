(ns leiningen.new.brim
  "Generate a brimming application project."
  (:require [leiningen.new.templates :refer [renderer year project-name
                                             ->files sanitize-ns name-to-path
                                             multi-segment]]
            [leiningen.core.main :as main]))


(def render (renderer "brim"))

(defn brim
  "FIXME: write documentation"
  [name]
  (let [main-ns (multi-segment (sanitize-ns name))
        data {:raw-name name
              :name (project-name name)
              :year (year)
              :namespace main-ns
              :nested-dirs (name-to-path main-ns)
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' brim project.")
    (->files data
      ["src/{{nested-dirs}}.clj" (render "core.clj" data)]
      ["Makefile" (render "Makefile" data)]
      ["project.clj" (render "project.clj" data)]
      [".gitignore" (render "gitignore" data)]
      ["test/{{nested-dirs}}_test.clj" (render "test.clj" data)]
      ["utils/lein.sh" (render "lein.sh" data) :executable true]
      ["README.md" (render "README.md" data)]
      ["LICENCE" (render "LICENCE" data)]
      "resources")))
