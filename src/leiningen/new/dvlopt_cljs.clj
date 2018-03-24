(ns leiningen.new.dvlopt-cljs

  {:author "Adam Helinski"}

  (:require [leiningen.core.main     :as main]
            [leiningen.new.templates :as templ]))




;;;;;;;;;;


(def render (templ/renderer "dvlopt-cljs"))




(defn dvlopt-cljs

  "Generate the template"

  [project-name]

  (let [data {:name      project-name
              :sanitized (templ/name-to-path project-name)}]
    (main/info (str "Generating a new kickass awesome project called \"" project-name "\""
                    \newline
                    "Dreams will come true !"))
    (templ/->files data
                   [".gitignore"
                    (render ".gitignore")]
                   ["LICENSE"
                    (render "LICENSE")]
                   ["README.md"
                    (render "README.md"
                            data)]
                   ["project.clj"
                    (render "project.clj"
                            data)]
                   ["dev/cljs/dev.cljs"
                    (render "dev.cljs"
                            data)]
                   ["src/cljs/{{ sanitized }}/core.cljs"
                    (render "core.cljs"
                            data)]
                   ["resources/public/index.html"
                    (render "index.html"
                            data)])))
