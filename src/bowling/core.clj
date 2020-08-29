(ns bowling.core
  (:gen-class))

(defn to-frame-scores [frames]
  )

(defn group-frames [rolls]
  (partition 2 rolls)
  )

(defn score [rolls]
  (reduce + (to-frame-scores (group-frames rolls))))