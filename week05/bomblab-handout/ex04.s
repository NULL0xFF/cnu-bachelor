.section    .data
scanf_str:
    .string "%d %d"
printf_str:
    .string "%d is greater \n"
val1:
    .int    0
val2:
    .int    0

.section    .text
.globl      main
main:
    movl    $val1, %esi
    movl    $val2, %edx
    movq    $scanf_str, %rdi

    movq    $0, %rax
    call    scanf

    movl    val1, %esi
    movl    val2, %edx

    cmpl    %edx, %esi

    jg      greater
    movl    %edx, %esi

greater:
    movq    $printf_str, %rdi
    movq    $0, %rax
    call    printf

    ret
