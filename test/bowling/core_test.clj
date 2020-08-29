(ns bowling.core-test
  (:require [clojure.test :refer :all]
            [bowling.core :refer :all]))

(deftest group-frames-test
  (testing "can group rolls into frames"
    (is (= [[1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1]]
           (group-frames [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1])))))

(deftest to-frame-scores-test
  (testing ""))

(deftest score-test
  '(testing "zero-game score"
    (is (= 0 (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))
  '(testing "simple game score no spares or strikes"
    (is (= 20 (score [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1])))
    (is (= 90 (score [9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0]))))
  '(testing "spare-game score"
    (is (= 29 (score [9 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1])))
    )
  )