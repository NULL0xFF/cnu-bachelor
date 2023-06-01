.section .data
message:
    .string "val1 = %d val2 = %d result = %d \n"
val1:
    .int 100
val2:
    .int 200

.section .text
.globl main

main:
    