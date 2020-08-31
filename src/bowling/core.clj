(ns bowling.core
  (:gen-class))

(defn group-frames [rolls]
  (partition 2 rolls)
  )

(defn next-frame-score [[frame & other]]
  (reduce + frame))

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