(defproject {{raw-name}} "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "BSD"
            :url "http://www.linfo.org/bsdlicense.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot {{namespace}}
  :pom-location "target/"
  :profiles {:uberjar {:aot :all}}
  :target-path "target/%s"
  :uberjar-name "{{name}}.jar"
  :plugins [[lein-ver "1.0.1"]
            [cider/cider-nrepl "0.8.0-SNAPSHOT"]])
