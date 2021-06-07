#!/bin/sh
pdftotext Build/main.pdf - | tr -d '\n' | wc -m
