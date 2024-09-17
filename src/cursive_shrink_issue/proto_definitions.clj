(ns cursive-shrink-issue.proto-definitions
  (:require [pronto.core :as pronto]
            [pronto.utils :as pronto-utils])
  (:import (shrink.issue SomeGrpcMock$SomeMessage)))

(pronto/defmapper proto-mapper
  [SomeGrpcMock$SomeMessage]
  :key-name-fn pronto-utils/->kebab-case
  :enum-value-fn pronto-utils/->kebab-case)
