(ns getting-started.core-test
  (:require [clojure.test :refer :all]
            [getting-started.core :refer :all]))

(deftest a-test
  (testing "Oh no! I fail."
    (is (= 0 1))))
