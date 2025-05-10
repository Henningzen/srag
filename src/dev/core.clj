(ns no.jansenh.srag.dev.core
  (:require [no.jansenh.srag.core :refer :all]
            [no.jansenh.srag :refer [get-config]]))

(def conf (get-config))

(let [text "This is today, and it's Tuesday"]

  ;; We will add the embedding-model, the tokenized, vectorized 'content'
  ;; text to our  embedding store.
  (.add embedding-store
        (.content

         ;; Create a vector onf numbers in a dense 3 dimensional Vector space.
         ;; The text will be 'tokenized'.
         (.embed embedding-model text))

        text))


(doseq [text ["This is today."
              "Yesterday was Tuesday."
              "Tomorrow is Friday."
              "In one week it's Tuesday once more."
              "There are many days from Tuesday to the weekend."
              "what time is it?"
              "Sometimes I have no clue what day it is."
              "I a few days from now, we will have a new week."
              "I once believed it was Saturday and chose to sleep in late."]]

  ;; We will add the embedding-model, the tokenized, vectorized 'content'
  ;; text to our  embedding store.
  (.add embedding-store
        (.content

         ;; Create a vector onf numbers in a dense 3 dimensional Vector space.
         ;; The text will be 'tokenized'.
         (.embed embedding-model text))

        text))


  ;; Our input text is embedded in the model, and the embedding in the store is associated with our
  ;; input text.
  ;; ------------
  ;;--->comment

(def search-text "What are the days of the week?")

  ;; Now, lets find and retrieve relevant text embeddings from the above store, the text previous stored,
  ;; with another NEW piece of text, that will be vectorized and tokenized as an embedding.

(let [ matches (.findRelevant embedding-store
                              (.content (.embed embedding-model search-text))
                              3)]
  {:type (type matches)
   :count (count matches)
   :embedded (->> matches
                  (map (fn [match]
                         {:score (.score match)
                          :text (.embedded match)})))})
