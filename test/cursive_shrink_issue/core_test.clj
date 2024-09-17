(ns cursive-shrink-issue.core-test
  (:require [clojure.test :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [cursive-shrink-issue.proto-definitions :as proto-defs]
            [pronto.core :as pronto])
  (:import (shrink.issue SomeGrpcMock$SomeMessage)
           (shrinkissue CustomPersistentMap)))

(deftest failing-test-using-pronto
  (testing "that using a `pronto` map fails"
    (tc/quick-check
      1
      (prop/for-all [text gen/string]
        (let [request (pronto/proto-map proto-defs/proto-mapper
                                        SomeGrpcMock$SomeMessage
                                        :message text)]
          (is request))))))

(deftest failing-test-using-custom-persistent-map
  (testing "that using a custom persistent map fails"
    (tc/quick-check
      1
      (prop/for-all [text gen/string]
        (let [request (CustomPersistentMap. {:message text} #{:message})]
          (is request))))))
