(ns bowling.core
  (:gen-class))

(defn group-frames [rolls]
  (partition 2 rolls)
  )

(defn spare? [frame]
  (and (= 10 (reduce + frame))
       (= 2 (count frame))))

(defn next-frame-score [[frame & other]]
  (let [simple-score (reduce + frame)]
    (if (spare? frame)
      (+ simple-score (first (first other)))
      simple-score)))

(defn to-frame-scores [frames]
  (loop [remaining frames
         scores []]

    (if (empty? remaining)
      scores
      (recur (rest remaining)
             (conj scores (next-frame-score remaining)))))
  ;(map #(reduce + %) frames)
  )

(defn score [rolls]
  (reduce + (to-frame-scores (group-frames rolls))))