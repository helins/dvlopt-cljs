(defproject {{ name }}
            "0.0.0-alpha0"

  :description      " ? "
  :url              " ? "
  :license          {:name "Eclipse Public License"
                     :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.7.1"
  :dependencies     [[org.clojure/clojure       "1.8.0"]
                     [org.clojure/clojurescript "1.9.854"]
                     [integrant                 "0.5.0"]
                     [re-frame                  "0.9.4"]]
  :plugins          [[lein-figwheel "0.5.12"]
                    [lein-cljsbuild "1.1.7" :exclusions [[org.clojure/clojure]]]]
  :source-paths     ["src"]
  :cljsbuild        {:builds
                      [{:id           "dev"
                        :source-paths ["dev"
                                       "src/cljs"]
                        :figwheel     {}
                        :compiler     {:main                 cljs.dev
                                       :asset-path           "js/compiled/out"
                                       :output-to            "resources/public/js/compiled/{{ name }}.js"
                                       :output-dir           "resources/public/js/compiled/out"
                                       :source-map-timestamp true
                                       :preloads             [devtools.preload]}}
                       {:id           "min"
                        :source-paths ["src/cljs"]
                        :compiler     {:output-to     "resources/public/js/compiled/{{ name }}.js"
                                       :main          {{ name }}.core
                                       :optimizations :advanced
                                       :pretty-print  false}}]}
  :figwheel         {;:server-ip "0.0.0.0"
                     :css-dirs   ["resources/public/css"]
                     :nrepl-port 7888}
  :profiles         {:dev {:dependencies  [[binaryage/devtools      "0.9.4"]
                                           [figwheel-sidecar        "0.5.12"]
                                           [com.cemerick/piggieback "0.2.2"]
                                           [binaryage/devtools      "0.9.4"]]
                           :source-paths  ["dev"
                                           "src"]
                           ;; :plugins [[cider/cider-nrepl "0.12.0"]]
                           :repl-options  {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
                           :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                                             :target-path]}})
