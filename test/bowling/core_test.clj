(ns bowling.core-test
  (:require [clojure.test :refer :all]
            [bowling.core :refer :all]))

(deftest group-frames-test
  (testing "can group rolls into frames"
    (is (= [[1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1]]
           (group-frames [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1])))))

(deftest spare?-test
  (testing "can tell when frame is a spare"
    (is (spare? [5 5])))
    (is (not (spare? [1 2])))
    (is (not (spare? [10]))))

(deftest spare-extra-score-test
        (testing "can calc the spare extra score given next frames"
          (is (= 4 (spare-extra-score [[4 3]]))))
          (is (= 9 (spare-extra-score [[9 0]]))))

(deftest next-frame-score-test
  (testing "can calc next frame score for a simple frame"
    (is (= 5 (next-frame-score [[3 2]]))))
  (testing "can calc next frame score for a spare frame"
    (is (= 11 (next-frame-score [[5 5] [1 2]]))))
  )


(deftest to-frame-scores-test
  (testing "can map frames to frame scores"
    (is (= [1 2 3 4 5 6 7 8 9 0]
           (to-frame-scores [[ 1 0] [ 1 1] [ 1 2] [ 1 3] [ 1 4] [ 1 5] [ 1 6] [ 1 7] [ 1 8] [ 0 0]]))))
  (testing "can map spare frame to frame score"
    (is (= [11 2 3 4 5 6 7 8 9 0]
           (to-frame-scores [[1 9] [1 1] [1 2] [1 3] [1 4] [1 5] [1 6] [1 7] [1 8] [0 0]])))))

(deftest score-test
  '(testing "zero-game score"
    (is (= 0 (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))
  '(testing "simple game score no spares or strikes"
    (is (= 20 (score [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1])))
    (is (= 90 (score [9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0]))))
  '(testing "spare-game score"
    (is (= 29 (score [9 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1])))))