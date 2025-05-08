;; -----------------------------------------------------------------------------
;; File: src/no/jansenh/srag.clj
;; Author: Henning Jansen - henning.jansen@jansenh.no
;; Copyright: (c) 2025
;; License: Distributed under the GNU General Public License v3.0
;; as described in the root of this project.
;; -----------------------------------------------------------------------------

(ns no.jansenh.srag
  (:require [no.jansenh.srag.core :as core]
            [cprop.core :refer [load-config]])
  (:gen-class))

;; Simple RAG - Retrieval Augmentet Generation
;;
;;   Main application entry point
;;
;;
;; authors:   Henning Jansen            henning.jansen@jansenh.no
;; since:     0.1.0                     2025-05-05
;; version:   0.1.0
;; -----------------------------------------------------------------------------

(defn get-config
  "Get configurqation map."
  [& rst]
  (load-config))

(defn simple-rag
  "Simple RAG - Retrieval Augmentet Generation."
  [data & rst]
  nil)

(defn -main
  "Application main entry point."
  [& args]
  (simple-rag args))
