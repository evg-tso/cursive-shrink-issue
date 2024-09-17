(def proto-version "3.25.3")

(defproject cursive-shrink-issue "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :java-source-paths ["src/java" "src/java/generated"]
  :dependencies [[org.clojure/clojure "1.11.3"]

                 ; Protobuf
                 [com.google.protobuf/protobuf-java ~proto-version]
                 [com.appsflyer/pronto "2.1.2"]]
  :main ^:skip-aot cursive-shrink-issue.core
  :target-path "target/%s"
  :lein-protodeps {:output-path   "src/java/generated"
                   :proto-version ~proto-version
                   :compile-grpc? false
                   :repos         {:local-proto {:repo-type    :filesystem
                                                 :config       {:path ""}
                                                 :proto-paths  ["schemas"]
                                                 :dependencies [[""]]}}}
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :dev {:plugins [[com.appsflyer/lein-protodeps "1.0.5"]]
                   :dependencies [[org.clojure/test.check "1.1.1"]
                                  [com.appsflyer/lein-protodeps "1.0.5"]]}})
