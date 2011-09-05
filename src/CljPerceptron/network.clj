(ns CljPerceptron.network
  (:use [CljPerceptron.perceptron]))

;let's represent the network as a map from
;perceptrons to a vector of perceptrons that feed into it

(defn eval-perceptron [p conn-map]
"produces the 1 or 0 value of the given perceptron
in the context of the given network of connections"
  (if (rational? p)
    p
      (p (map (fn [upstream-p] (eval-perceptron (eval upstream-p) conn-map)) (get conn-map p)))))

