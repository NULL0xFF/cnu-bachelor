.section    .data
scanf_str:
    .string "%d"
printf_str:
    .string "result : %d \n"
i:
    .int    0
sum:
    .int    0
n:
    .int    0

.section    .text
.globl      main

main:
    movl    $n, %esi
    movq    $scanf_str, %rdi

    movq    $0, %rax
    call    scanf

    movl    sum, %edx
    movl    i, %ecx

loop:
    addl    %ecx, %edx
    incl    %ecx
    cmpl    n, %ecx
    jle     loop

    movl    %edx, %esi

    movq    $printf_str, %rdi
    movq    $0, %rax
    call    printf
    ret
