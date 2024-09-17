(ns cursive-shrink-issue.core-test
  (:require [clojure.test :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [cursive-shrink-issue.proto-definitions :as proto-defs]
            [pronto.core :as pronto])
  (:import (shrink.issue SomeGrpcMock$SomeMessage)))

(deftest failing-test
  (testing "that a no-shrink generator fails"
    (tc/quick-check
      1
      (prop/for-all [text (gen/no-shrink gen/string)]
        (let [request (pronto/proto-map proto-defs/proto-mapper
                                        SomeGrpcMock$SomeMessage
                                        :message text)]
          (is request))))))
