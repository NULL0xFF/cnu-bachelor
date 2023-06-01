
bomb:     file format elf64-x86-64


Disassembly of section .init:

0000000000400b00 <_init>:
  400b00:	48 83 ec 08          	sub    $0x8,%rsp
  400b04:	48 8b 05 ed 34 20 00 	mov    0x2034ed(%rip),%rax        # 603ff8 <_DYNAMIC+0x1d0>
  400b0b:	48 85 c0             	test   %rax,%rax
  400b0e:	74 05                	je     400b15 <_init+0x15>
  400b10:	e8 db 01 00 00       	callq  400cf0 <socket@plt+0x10>
  400b15:	48 83 c4 08          	add    $0x8,%rsp
  400b19:	c3                   	retq   

Disassembly of section .plt:

0000000000400b20 <getenv@plt-0x10>:
  400b20:	ff 35 e2 34 20 00    	pushq  0x2034e2(%rip)        # 604008 <_GLOBAL_OFFSET_TABLE_+0x8>
  400b26:	ff 25 e4 34 20 00    	jmpq   *0x2034e4(%rip)        # 604010 <_GLOBAL_OFFSET_TABLE_+0x10>
  400b2c:	0f 1f 40 00          	nopl   0x0(%rax)

0000000000400b30 <getenv@plt>:
  400b30:	ff 25 e2 34 20 00    	jmpq   *0x2034e2(%rip)        # 604018 <_GLOBAL_OFFSET_TABLE_+0x18>
  400b36:	68 00 00 00 00       	pushq  $0x0
  400b3b:	e9 e0 ff ff ff       	jmpq   400b20 <_init+0x20>

0000000000400b40 <strcasecmp@plt>:
  400b40:	ff 25 da 34 20 00    	jmpq   *0x2034da(%rip)        # 604020 <_GLOBAL_OFFSET_TABLE_+0x20>
  400b46:	68 01 00 00 00       	pushq  $0x1
  400b4b:	e9 d0 ff ff ff       	jmpq   400b20 <_init+0x20>

0000000000400b50 <__errno_location@plt>:
  400b50:	ff 25 d2 34 20 00    	jmpq   *0x2034d2(%rip)        # 604028 <_GLOBAL_OFFSET_TABLE_+0x28>
  400b56:	68 02 00 00 00       	pushq  $0x2
  400b5b:	e9 c0 ff ff ff       	jmpq   400b20 <_init+0x20>

0000000000400b60 <strcpy@plt>:
  400b60:	ff 25 ca 34 20 00    	jmpq   *0x2034ca(%rip)        # 604030 <_GLOBAL_OFFSET_TABLE_+0x30>
  400b66:	68 03 00 00 00       	pushq  $0x3
  400b6b:	e9 b0 ff ff ff       	jmpq   400b20 <_init+0x20>

0000000000400b70 <puts@plt>:
  400b70:	ff 25 c2 34 20 00    	jmpq   *0x2034c2(%rip)        # 604038 <_GLOBAL_OFFSET_TABLE_+0x38>
  400b76:	68 04 00 00 00       	pushq  $0x4
  400b7b:	e9 a0 ff ff ff       	jmpq   400b20 <_init+0x20>

0000000000400b80 <write@plt>:
  400b80:	ff 25 ba 34 20 00    	jmpq   *0x2034ba(%rip)        # 604040 <_GLOBAL_OFFSET_TABLE_+0x40>
  400b86:	68 05 00 00 00       	pushq  $0x5
  400b8b:	e9 90 ff ff ff       	jmpq   400b20 <_init+0x20>

0000000000400b90 <__stack_chk_fail@plt>:
  400b90:	ff 25 b2 34 20 00    	jmpq   *0x2034b2(%rip)        # 604048 <_GLOBAL_OFFSET_TABLE_+0x48>
  400b96:	68 06 00 00 00       	pushq  $0x6
  400b9b:	e9 80 ff ff ff       	jmpq   400b20 <_init+0x20>

0000000000400ba0 <alarm@plt>:
  400ba0:	ff 25 aa 34 20 00    	jmpq   *0x2034aa(%rip)        # 604050 <_GLOBAL_OFFSET_TABLE_+0x50>
  400ba6:	68 07 00 00 00       	pushq  $0x7
  400bab:	e9 70 ff ff ff       	jmpq   400b20 <_init+0x20>

0000000000400bb0 <close@plt>:
  400bb0:	ff 25 a2 34 20 00    	jmpq   *0x2034a2(%rip)        # 604058 <_GLOBAL_OFFSET_TABLE_+0x58>
  400bb6:	68 08 00 00 00       	pushq  $0x8
  400bbb:	e9 60 ff ff ff       	jmpq   400b20 <_init+0x20>

0000000000400bc0 <read@plt>:
  400bc0:	ff 25 9a 34 20 00    	jmpq   *0x20349a(%rip)        # 604060 <_GLOBAL_OFFSET_TABLE_+0x60>
  400bc6:	68 09 00 00 00       	pushq  $0x9
  400bcb:	e9 50 ff ff ff       	jmpq   400b20 <_init+0x20>

0000000000400bd0 <__libc_start_main@plt>:
  400bd0:	ff 25 92 34 20 00    	jmpq   *0x203492(%rip)        # 604068 <_GLOBAL_OFFSET_TABLE_+0x68>
  400bd6:	68 0a 00 00 00       	pushq  $0xa
  400bdb:	e9 40 ff ff ff       	jmpq   400b20 <_init+0x20>

0000000000400be0 <fgets@plt>:
  400be0:	ff 25 8a 34 20 00    	jmpq   *0x20348a(%rip)        # 604070 <_GLOBAL_OFFSET_TABLE_+0x70>
  400be6:	68 0b 00 00 00       	pushq  $0xb
  400beb:	e9 30 ff ff ff       	jmpq   400b20 <_init+0x20>

0000000000400bf0 <signal@plt>:
  400bf0:	ff 25 82 34 20 00    	jmpq   *0x203482(%rip)        # 604078 <_GLOBAL_OFFSET_TABLE_+0x78>
  400bf6:	68 0c 00 00 00       	pushq  $0xc
  400bfb:	e9 20 ff ff ff       	jmpq   400b20 <_init+0x20>

0000000000400c00 <gethostbyname@plt>:
  400c00:	ff 25 7a 34 20 00    	jmpq   *0x20347a(%rip)        # 604080 <_GLOBAL_OFFSET_TABLE_+0x80>
  400c06:	68 0d 00 00 00       	pushq  $0xd
  400c0b:	e9 10 ff ff ff       	jmpq   400b20 <_init+0x20>

0000000000400c10 <__memmove_chk@plt>:
  400c10:	ff 25 72 34 20 00    	jmpq   *0x203472(%rip)        # 604088 <_GLOBAL_OFFSET_TABLE_+0x88>
  400c16:	68 0e 00 00 00       	pushq  $0xe
  400c1b:	e9 00 ff ff ff       	jmpq   400b20 <_init+0x20>

0000000000400c20 <strtol@plt>:
  400c20:	ff 25 6a 34 20 00    	jmpq   *0x20346a(%rip)        # 604090 <_GLOBAL_OFFSET_TABLE_+0x90>
  400c26:	68 0f 00 00 00       	pushq  $0xf
  400c2b:	e9 f0 fe ff ff       	jmpq   400b20 <_init+0x20>

0000000000400c30 <fflush@plt>:
  400c30:	ff 25 62 34 20 00    	jmpq   *0x203462(%rip)        # 604098 <_GLOBAL_OFFSET_TABLE_+0x98>
  400c36:	68 10 00 00 00       	pushq  $0x10
  400c3b:	e9 e0 fe ff ff       	jmpq   400b20 <_init+0x20>

0000000000400c40 <__isoc99_sscanf@plt>:
  400c40:	ff 25 5a 34 20 00    	jmpq   *0x20345a(%rip)        # 6040a0 <_GLOBAL_OFFSET_TABLE_+0xa0>
  400c46:	68 11 00 00 00       	pushq  $0x11
  400c4b:	e9 d0 fe ff ff       	jmpq   400b20 <_init+0x20>

0000000000400c50 <__printf_chk@plt>:
  400c50:	ff 25 52 34 20 00    	jmpq   *0x203452(%rip)        # 6040a8 <_GLOBAL_OFFSET_TABLE_+0xa8>
  400c56:	68 12 00 00 00       	pushq  $0x12
  400c5b:	e9 c0 fe ff ff       	jmpq   400b20 <_init+0x20>

0000000000400c60 <fopen@plt>:
  400c60:	ff 25 4a 34 20 00    	jmpq   *0x20344a(%rip)        # 6040b0 <_GLOBAL_OFFSET_TABLE_+0xb0>
  400c66:	68 13 00 00 00       	pushq  $0x13
  400c6b:	e9 b0 fe ff ff       	jmpq   400b20 <_init+0x20>

0000000000400c70 <gethostname@plt>:
  400c70:	ff 25 42 34 20 00    	jmpq   *0x203442(%rip)        # 6040b8 <_GLOBAL_OFFSET_TABLE_+0xb8>
  400c76:	68 14 00 00 00       	pushq  $0x14
  400c7b:	e9 a0 fe ff ff       	jmpq   400b20 <_init+0x20>

0000000000400c80 <exit@plt>:
  400c80:	ff 25 3a 34 20 00    	jmpq   *0x20343a(%rip)        # 6040c0 <_GLOBAL_OFFSET_TABLE_+0xc0>
  400c86:	68 15 00 00 00       	pushq  $0x15
  400c8b:	e9 90 fe ff ff       	jmpq   400b20 <_init+0x20>

0000000000400c90 <connect@plt>:
  400c90:	ff 25 32 34 20 00    	jmpq   *0x203432(%rip)        # 6040c8 <_GLOBAL_OFFSET_TABLE_+0xc8>
  400c96:	68 16 00 00 00       	pushq  $0x16
  400c9b:	e9 80 fe ff ff       	jmpq   400b20 <_init+0x20>

0000000000400ca0 <__fprintf_chk@plt>:
  400ca0:	ff 25 2a 34 20 00    	jmpq   *0x20342a(%rip)        # 6040d0 <_GLOBAL_OFFSET_TABLE_+0xd0>
  400ca6:	68 17 00 00 00       	pushq  $0x17
  400cab:	e9 70 fe ff ff       	jmpq   400b20 <_init+0x20>

0000000000400cb0 <sleep@plt>:
  400cb0:	ff 25 22 34 20 00    	jmpq   *0x203422(%rip)        # 6040d8 <_GLOBAL_OFFSET_TABLE_+0xd8>
  400cb6:	68 18 00 00 00       	pushq  $0x18
  400cbb:	e9 60 fe ff ff       	jmpq   400b20 <_init+0x20>

0000000000400cc0 <__ctype_b_loc@plt>:
  400cc0:	ff 25 1a 34 20 00    	jmpq   *0x20341a(%rip)        # 6040e0 <_GLOBAL_OFFSET_TABLE_+0xe0>
  400cc6:	68 19 00 00 00       	pushq  $0x19
  400ccb:	e9 50 fe ff ff       	jmpq   400b20 <_init+0x20>

0000000000400cd0 <__sprintf_chk@plt>:
  400cd0:	ff 25 12 34 20 00    	jmpq   *0x203412(%rip)        # 6040e8 <_GLOBAL_OFFSET_TABLE_+0xe8>
  400cd6:	68 1a 00 00 00       	pushq  $0x1a
  400cdb:	e9 40 fe ff ff       	jmpq   400b20 <_init+0x20>

0000000000400ce0 <socket@plt>:
  400ce0:	ff 25 0a 34 20 00    	jmpq   *0x20340a(%rip)        # 6040f0 <_GLOBAL_OFFSET_TABLE_+0xf0>
  400ce6:	68 1b 00 00 00       	pushq  $0x1b
  400ceb:	e9 30 fe ff ff       	jmpq   400b20 <_init+0x20>

Disassembly of section .plt.got:

0000000000400cf0 <.plt.got>:
  400cf0:	ff 25 02 33 20 00    	jmpq   *0x203302(%rip)        # 603ff8 <_DYNAMIC+0x1d0>
  400cf6:	66 90                	xchg   %ax,%ax

Disassembly of section .text:

0000000000400d00 <_start>:
  400d00:	31 ed                	xor    %ebp,%ebp
  400d02:	49 89 d1             	mov    %rdx,%r9
  400d05:	5e                   	pop    %rsi
  400d06:	48 89 e2             	mov    %rsp,%rdx
  400d09:	48 83 e4 f0          	and    $0xfffffffffffffff0,%rsp
  400d0d:	50                   	push   %rax
  400d0e:	54                   	push   %rsp
  400d0f:	49 c7 c0 d0 24 40 00 	mov    $0x4024d0,%r8
  400d16:	48 c7 c1 60 24 40 00 	mov    $0x402460,%rcx
  400d1d:	48 c7 c7 f6 0d 40 00 	mov    $0x400df6,%rdi
  400d24:	e8 a7 fe ff ff       	callq  400bd0 <__libc_start_main@plt>
  400d29:	f4                   	hlt    
  400d2a:	66 0f 1f 44 00 00    	nopw   0x0(%rax,%rax,1)

0000000000400d30 <deregister_tm_clones>:
  400d30:	b8 87 47 60 00       	mov    $0x604787,%eax
  400d35:	55                   	push   %rbp
  400d36:	48 2d 80 47 60 00    	sub    $0x604780,%rax
  400d3c:	48 83 f8 0e          	cmp    $0xe,%rax
  400d40:	48 89 e5             	mov    %rsp,%rbp
  400d43:	76 1b                	jbe    400d60 <deregister_tm_clones+0x30>
  400d45:	b8 00 00 00 00       	mov    $0x0,%eax
  400d4a:	48 85 c0             	test   %rax,%rax
  400d4d:	74 11                	je     400d60 <deregister_tm_clones+0x30>
  400d4f:	5d                   	pop    %rbp
  400d50:	bf 80 47 60 00       	mov    $0x604780,%edi
  400d55:	ff e0                	jmpq   *%rax
  400d57:	66 0f 1f 84 00 00 00 	nopw   0x0(%rax,%rax,1)
  400d5e:	00 00 
  400d60:	5d                   	pop    %rbp
  400d61:	c3                   	retq   
  400d62:	0f 1f 40 00          	nopl   0x0(%rax)
  400d66:	66 2e 0f 1f 84 00 00 	nopw   %cs:0x0(%rax,%rax,1)
  400d6d:	00 00 00 

0000000000400d70 <register_tm_clones>:
  400d70:	be 80 47 60 00       	mov    $0x604780,%esi
  400d75:	55                   	push   %rbp
  400d76:	48 81 ee 80 47 60 00 	sub    $0x604780,%rsi
  400d7d:	48 c1 fe 03          	sar    $0x3,%rsi
  400d81:	48 89 e5             	mov    %rsp,%rbp
  400d84:	48 89 f0             	mov    %rsi,%rax
  400d87:	48 c1 e8 3f          	shr    $0x3f,%rax
  400d8b:	48 01 c6             	add    %rax,%rsi
  400d8e:	48 d1 fe             	sar    %rsi
  400d91:	74 15                	je     400da8 <register_tm_clones+0x38>
  400d93:	b8 00 00 00 00       	mov    $0x0,%eax
  400d98:	48 85 c0             	test   %rax,%rax
  400d9b:	74 0b                	je     400da8 <register_tm_clones+0x38>
  400d9d:	5d                   	pop    %rbp
  400d9e:	bf 80 47 60 00       	mov    $0x604780,%edi
  400da3:	ff e0                	jmpq   *%rax
  400da5:	0f 1f 00             	nopl   (%rax)
  400da8:	5d                   	pop    %rbp
  400da9:	c3                   	retq   
  400daa:	66 0f 1f 44 00 00    	nopw   0x0(%rax,%rax,1)

0000000000400db0 <__do_global_dtors_aux>:
  400db0:	80 3d f1 39 20 00 00 	cmpb   $0x0,0x2039f1(%rip)        # 6047a8 <completed.7594>
  400db7:	75 11                	jne    400dca <__do_global_dtors_aux+0x1a>
  400db9:	55                   	push   %rbp
  400dba:	48 89 e5             	mov    %rsp,%rbp
  400dbd:	e8 6e ff ff ff       	callq  400d30 <deregister_tm_clones>
  400dc2:	5d                   	pop    %rbp
  400dc3:	c6 05 de 39 20 00 01 	movb   $0x1,0x2039de(%rip)        # 6047a8 <completed.7594>
  400dca:	f3 c3                	repz retq 
  400dcc:	0f 1f 40 00          	nopl   0x0(%rax)

0000000000400dd0 <frame_dummy>:
  400dd0:	bf 20 3e 60 00       	mov    $0x603e20,%edi
  400dd5:	48 83 3f 00          	cmpq   $0x0,(%rdi)
  400dd9:	75 05                	jne    400de0 <frame_dummy+0x10>
  400ddb:	eb 93                	jmp    400d70 <register_tm_clones>
  400ddd:	0f 1f 00             	nopl   (%rax)
  400de0:	b8 00 00 00 00       	mov    $0x0,%eax
  400de5:	48 85 c0             	test   %rax,%rax
  400de8:	74 f1                	je     400ddb <frame_dummy+0xb>
  400dea:	55                   	push   %rbp
  400deb:	48 89 e5             	mov    %rsp,%rbp
  400dee:	ff d0                	callq  *%rax
  400df0:	5d                   	pop    %rbp
  400df1:	e9 7a ff ff ff       	jmpq   400d70 <register_tm_clones>

0000000000400df6 <main>:
  400df6:	53                   	push   %rbx
  400df7:	83 ff 01             	cmp    $0x1,%edi
  400dfa:	75 10                	jne    400e0c <main+0x16>
  400dfc:	48 8b 05 8d 39 20 00 	mov    0x20398d(%rip),%rax        # 604790 <stdin@@GLIBC_2.2.5>
  400e03:	48 89 05 a6 39 20 00 	mov    %rax,0x2039a6(%rip)        # 6047b0 <infile>
  400e0a:	eb 63                	jmp    400e6f <main+0x79>
  400e0c:	48 89 f3             	mov    %rsi,%rbx
  400e0f:	83 ff 02             	cmp    $0x2,%edi
  400e12:	75 3a                	jne    400e4e <main+0x58>
  400e14:	48 8b 7e 08          	mov    0x8(%rsi),%rdi
  400e18:	be e4 24 40 00       	mov    $0x4024e4,%esi
  400e1d:	e8 3e fe ff ff       	callq  400c60 <fopen@plt>
  400e22:	48 89 05 87 39 20 00 	mov    %rax,0x203987(%rip)        # 6047b0 <infile>
  400e29:	48 85 c0             	test   %rax,%rax
  400e2c:	75 41                	jne    400e6f <main+0x79>
}

__fortify_function int
printf (const char *__restrict __fmt, ...)
{
  return __printf_chk (__USE_FORTIFY_LEVEL - 1, __fmt, __va_arg_pack ());
  400e2e:	48 8b 4b 08          	mov    0x8(%rbx),%rcx
  400e32:	48 8b 13             	mov    (%rbx),%rdx
  400e35:	be e6 24 40 00       	mov    $0x4024e6,%esi
  400e3a:	bf 01 00 00 00       	mov    $0x1,%edi
  400e3f:	e8 0c fe ff ff       	callq  400c50 <__printf_chk@plt>
  400e44:	bf 08 00 00 00       	mov    $0x8,%edi
  400e49:	e8 32 fe ff ff       	callq  400c80 <exit@plt>
  400e4e:	48 8b 16             	mov    (%rsi),%rdx
  400e51:	be 03 25 40 00       	mov    $0x402503,%esi
  400e56:	bf 01 00 00 00       	mov    $0x1,%edi
  400e5b:	b8 00 00 00 00       	mov    $0x0,%eax
  400e60:	e8 eb fd ff ff       	callq  400c50 <__printf_chk@plt>
  400e65:	bf 08 00 00 00       	mov    $0x8,%edi
  400e6a:	e8 11 fe ff ff       	callq  400c80 <exit@plt>
  400e6f:	e8 93 05 00 00       	callq  401407 <initialize_bomb>
  400e74:	bf 68 25 40 00       	mov    $0x402568,%edi
  400e79:	e8 f2 fc ff ff       	callq  400b70 <puts@plt>
  400e7e:	bf a8 25 40 00       	mov    $0x4025a8,%edi
  400e83:	e8 e8 fc ff ff       	callq  400b70 <puts@plt>
  400e88:	e8 5c 08 00 00       	callq  4016e9 <read_line>
  400e8d:	48 89 c7             	mov    %rax,%rdi
  400e90:	e8 98 00 00 00       	callq  400f2d <phase_1>
  400e95:	e8 75 09 00 00       	callq  40180f <phase_defused>
  400e9a:	bf d8 25 40 00       	mov    $0x4025d8,%edi
  400e9f:	e8 cc fc ff ff       	callq  400b70 <puts@plt>
  400ea4:	e8 40 08 00 00       	callq  4016e9 <read_line>
  400ea9:	48 89 c7             	mov    %rax,%rdi
  400eac:	e8 98 00 00 00       	callq  400f49 <phase_2>
  400eb1:	e8 59 09 00 00       	callq  40180f <phase_defused>
  400eb6:	bf 1d 25 40 00       	mov    $0x40251d,%edi
  400ebb:	e8 b0 fc ff ff       	callq  400b70 <puts@plt>
  400ec0:	e8 24 08 00 00       	callq  4016e9 <read_line>
  400ec5:	48 89 c7             	mov    %rax,%rdi
  400ec8:	e8 e0 00 00 00       	callq  400fad <phase_3>
  400ecd:	e8 3d 09 00 00       	callq  40180f <phase_defused>
  400ed2:	bf 3b 25 40 00       	mov    $0x40253b,%edi
  400ed7:	e8 94 fc ff ff       	callq  400b70 <puts@plt>
  400edc:	e8 08 08 00 00       	callq  4016e9 <read_line>
  400ee1:	48 89 c7             	mov    %rax,%rdi
  400ee4:	e8 d2 01 00 00       	callq  4010bb <phase_4>
  400ee9:	e8 21 09 00 00       	callq  40180f <phase_defused>
  400eee:	bf 08 26 40 00       	mov    $0x402608,%edi
  400ef3:	e8 78 fc ff ff       	callq  400b70 <puts@plt>
  400ef8:	e8 ec 07 00 00       	callq  4016e9 <read_line>
  400efd:	48 89 c7             	mov    %rax,%rdi
  400f00:	e8 28 02 00 00       	callq  40112d <phase_5>
  400f05:	e8 05 09 00 00       	callq  40180f <phase_defused>
  400f0a:	bf 4a 25 40 00       	mov    $0x40254a,%edi
  400f0f:	e8 5c fc ff ff       	callq  400b70 <puts@plt>
  400f14:	e8 d0 07 00 00       	callq  4016e9 <read_line>
  400f19:	48 89 c7             	mov    %rax,%rdi
  400f1c:	e8 4d 02 00 00       	callq  40116e <phase_6>
  400f21:	e8 e9 08 00 00       	callq  40180f <phase_defused>
  400f26:	b8 00 00 00 00       	mov    $0x0,%eax
  400f2b:	5b                   	pop    %rbx
  400f2c:	c3                   	retq   

0000000000400f2d <phase_1>:
  400f2d:	48 83 ec 08          	sub    $0x8,%rsp
  400f31:	be 30 26 40 00       	mov    $0x402630,%esi
  400f36:	e8 65 04 00 00       	callq  4013a0 <strings_not_equal>
  400f3b:	85 c0                	test   %eax,%eax
  400f3d:	74 05                	je     400f44 <phase_1+0x17>
  400f3f:	e8 30 07 00 00       	callq  401674 <explode_bomb>
  400f44:	48 83 c4 08          	add    $0x8,%rsp
  400f48:	c3                   	retq   

0000000000400f49 <phase_2>:
  400f49:	55                   	push   %rbp
  400f4a:	53                   	push   %rbx
  400f4b:	48 83 ec 28          	sub    $0x28,%rsp
  400f4f:	64 48 8b 04 25 28 00 	mov    %fs:0x28,%rax
  400f56:	00 00 
  400f58:	48 89 44 24 18       	mov    %rax,0x18(%rsp)
  400f5d:	31 c0                	xor    %eax,%eax
  400f5f:	48 89 e6             	mov    %rsp,%rsi
  400f62:	e8 43 07 00 00       	callq  4016aa <read_six_numbers>
  400f67:	83 3c 24 01          	cmpl   $0x1,(%rsp)
  400f6b:	74 05                	je     400f72 <phase_2+0x29>
  400f6d:	e8 02 07 00 00       	callq  401674 <explode_bomb>
  400f72:	48 89 e3             	mov    %rsp,%rbx
  400f75:	48 8d 6c 24 14       	lea    0x14(%rsp),%rbp
  400f7a:	8b 03                	mov    (%rbx),%eax
  400f7c:	01 c0                	add    %eax,%eax
  400f7e:	39 43 04             	cmp    %eax,0x4(%rbx)
  400f81:	74 05                	je     400f88 <phase_2+0x3f>
  400f83:	e8 ec 06 00 00       	callq  401674 <explode_bomb>
  400f88:	48 83 c3 04          	add    $0x4,%rbx
  400f8c:	48 39 eb             	cmp    %rbp,%rbx
  400f8f:	75 e9                	jne    400f7a <phase_2+0x31>
  400f91:	48 8b 44 24 18       	mov    0x18(%rsp),%rax
  400f96:	64 48 33 04 25 28 00 	xor    %fs:0x28,%rax
  400f9d:	00 00 
  400f9f:	74 05                	je     400fa6 <phase_2+0x5d>
  400fa1:	e8 ea fb ff ff       	callq  400b90 <__stack_chk_fail@plt>
  400fa6:	48 83 c4 28          	add    $0x28,%rsp
  400faa:	5b                   	pop    %rbx
  400fab:	5d                   	pop    %rbp
  400fac:	c3                   	retq   

0000000000400fad <phase_3>:
  400fad:	48 83 ec 18          	sub    $0x18,%rsp
  400fb1:	64 48 8b 04 25 28 00 	mov    %fs:0x28,%rax
  400fb8:	00 00 
  400fba:	48 89 44 24 08       	mov    %rax,0x8(%rsp)
  400fbf:	31 c0                	xor    %eax,%eax
  400fc1:	48 8d 4c 24 04       	lea    0x4(%rsp),%rcx
  400fc6:	48 89 e2             	mov    %rsp,%rdx
  400fc9:	be 6d 29 40 00       	mov    $0x40296d,%esi
  400fce:	e8 6d fc ff ff       	callq  400c40 <__isoc99_sscanf@plt>
  400fd3:	83 f8 01             	cmp    $0x1,%eax
  400fd6:	7f 05                	jg     400fdd <phase_3+0x30>
  400fd8:	e8 97 06 00 00       	callq  401674 <explode_bomb>
  400fdd:	83 3c 24 07          	cmpl   $0x7,(%rsp)
  400fe1:	77 65                	ja     401048 <phase_3+0x9b>
  400fe3:	8b 04 24             	mov    (%rsp),%eax
  400fe6:	ff 24 c5 a0 26 40 00 	jmpq   *0x4026a0(,%rax,8)
  400fed:	b8 af 02 00 00       	mov    $0x2af,%eax
  400ff2:	eb 05                	jmp    400ff9 <phase_3+0x4c>
  400ff4:	b8 00 00 00 00       	mov    $0x0,%eax
  400ff9:	2d 3d 02 00 00       	sub    $0x23d,%eax
  400ffe:	eb 05                	jmp    401005 <phase_3+0x58>
  401000:	b8 00 00 00 00       	mov    $0x0,%eax
  401005:	05 51 01 00 00       	add    $0x151,%eax
  40100a:	eb 05                	jmp    401011 <phase_3+0x64>
  40100c:	b8 00 00 00 00       	mov    $0x0,%eax
  401011:	2d cb 00 00 00       	sub    $0xcb,%eax
  401016:	eb 05                	jmp    40101d <phase_3+0x70>
  401018:	b8 00 00 00 00       	mov    $0x0,%eax
  40101d:	05 cb 00 00 00       	add    $0xcb,%eax
  401022:	eb 05                	jmp    401029 <phase_3+0x7c>
  401024:	b8 00 00 00 00       	mov    $0x0,%eax
  401029:	2d cb 00 00 00       	sub    $0xcb,%eax
  40102e:	eb 05                	jmp    401035 <phase_3+0x88>
  401030:	b8 00 00 00 00       	mov    $0x0,%eax
  401035:	05 cb 00 00 00       	add    $0xcb,%eax
  40103a:	eb 05                	jmp    401041 <phase_3+0x94>
  40103c:	b8 00 00 00 00       	mov    $0x0,%eax
  401041:	2d cb 00 00 00       	sub    $0xcb,%eax
  401046:	eb 0a                	jmp    401052 <phase_3+0xa5>
  401048:	e8 27 06 00 00       	callq  401674 <explode_bomb>
  40104d:	b8 00 00 00 00       	mov    $0x0,%eax
  401052:	83 3c 24 05          	cmpl   $0x5,(%rsp)
  401056:	7f 06                	jg     40105e <phase_3+0xb1>
  401058:	3b 44 24 04          	cmp    0x4(%rsp),%eax
  40105c:	74 05                	je     401063 <phase_3+0xb6>
  40105e:	e8 11 06 00 00       	callq  401674 <explode_bomb>
  401063:	48 8b 44 24 08       	mov    0x8(%rsp),%rax
  401068:	64 48 33 04 25 28 00 	xor    %fs:0x28,%rax
  40106f:	00 00 
  401071:	74 05                	je     401078 <phase_3+0xcb>
  401073:	e8 18 fb ff ff       	callq  400b90 <__stack_chk_fail@plt>
  401078:	48 83 c4 18          	add    $0x18,%rsp
  40107c:	c3                   	retq   

000000000040107d <func4>:
  40107d:	48 83 ec 08          	sub    $0x8,%rsp
  401081:	89 d0                	mov    %edx,%eax
  401083:	29 f0                	sub    %esi,%eax
  401085:	89 c1                	mov    %eax,%ecx
  401087:	c1 e9 1f             	shr    $0x1f,%ecx
  40108a:	01 c8                	add    %ecx,%eax
  40108c:	d1 f8                	sar    %eax
  40108e:	8d 0c 30             	lea    (%rax,%rsi,1),%ecx
  401091:	39 f9                	cmp    %edi,%ecx
  401093:	7e 0c                	jle    4010a1 <func4+0x24>
  401095:	8d 51 ff             	lea    -0x1(%rcx),%edx
  401098:	e8 e0 ff ff ff       	callq  40107d <func4>
  40109d:	01 c0                	add    %eax,%eax
  40109f:	eb 15                	jmp    4010b6 <func4+0x39>
  4010a1:	b8 00 00 00 00       	mov    $0x0,%eax
  4010a6:	39 f9                	cmp    %edi,%ecx
  4010a8:	7d 0c                	jge    4010b6 <func4+0x39>
  4010aa:	8d 71 01             	lea    0x1(%rcx),%esi
  4010ad:	e8 cb ff ff ff       	callq  40107d <func4>
  4010b2:	8d 44 00 01          	lea    0x1(%rax,%rax,1),%eax
  4010b6:	48 83 c4 08          	add    $0x8,%rsp
  4010ba:	c3                   	retq   

00000000004010bb <phase_4>:
  4010bb:	48 83 ec 18          	sub    $0x18,%rsp
  4010bf:	64 48 8b 04 25 28 00 	mov    %fs:0x28,%rax
  4010c6:	00 00 
  4010c8:	48 89 44 24 08       	mov    %rax,0x8(%rsp)
  4010cd:	31 c0                	xor    %eax,%eax
  4010cf:	48 8d 4c 24 04       	lea    0x4(%rsp),%rcx
  4010d4:	48 89 e2             	mov    %rsp,%rdx
  4010d7:	be 6d 29 40 00       	mov    $0x40296d,%esi
  4010dc:	e8 5f fb ff ff       	callq  400c40 <__isoc99_sscanf@plt>
  4010e1:	83 f8 02             	cmp    $0x2,%eax
  4010e4:	75 06                	jne    4010ec <phase_4+0x31>
  4010e6:	83 3c 24 0e          	cmpl   $0xe,(%rsp)
  4010ea:	76 05                	jbe    4010f1 <phase_4+0x36>
  4010ec:	e8 83 05 00 00       	callq  401674 <explode_bomb>
  4010f1:	ba 0e 00 00 00       	mov    $0xe,%edx
  4010f6:	be 00 00 00 00       	mov    $0x0,%esi
  4010fb:	8b 3c 24             	mov    (%rsp),%edi
  4010fe:	e8 7a ff ff ff       	callq  40107d <func4>
  401103:	85 c0                	test   %eax,%eax
  401105:	75 07                	jne    40110e <phase_4+0x53>
  401107:	83 7c 24 04 00       	cmpl   $0x0,0x4(%rsp)
  40110c:	74 05                	je     401113 <phase_4+0x58>
  40110e:	e8 61 05 00 00       	callq  401674 <explode_bomb>
  401113:	48 8b 44 24 08       	mov    0x8(%rsp),%rax
  401118:	64 48 33 04 25 28 00 	xor    %fs:0x28,%rax
  40111f:	00 00 
  401121:	74 05                	je     401128 <phase_4+0x6d>
  401123:	e8 68 fa ff ff       	callq  400b90 <__stack_chk_fail@plt>
  401128:	48 83 c4 18          	add    $0x18,%rsp
  40112c:	c3                   	retq   

000000000040112d <phase_5>:
  40112d:	53                   	push   %rbx
  40112e:	48 89 fb             	mov    %rdi,%rbx
  401131:	e8 4c 02 00 00       	callq  401382 <string_length>
  401136:	83 f8 06             	cmp    $0x6,%eax
  401139:	74 05                	je     401140 <phase_5+0x13>
  40113b:	e8 34 05 00 00       	callq  401674 <explode_bomb>
  401140:	48 89 d8             	mov    %rbx,%rax
  401143:	48 8d 7b 06          	lea    0x6(%rbx),%rdi
  401147:	b9 00 00 00 00       	mov    $0x0,%ecx
  40114c:	0f b6 10             	movzbl (%rax),%edx
  40114f:	83 e2 0f             	and    $0xf,%edx
  401152:	03 0c 95 e0 26 40 00 	add    0x4026e0(,%rdx,4),%ecx
  401159:	48 83 c0 01          	add    $0x1,%rax
  40115d:	48 39 f8             	cmp    %rdi,%rax
  401160:	75 ea                	jne    40114c <phase_5+0x1f>
  401162:	83 f9 4a             	cmp    $0x4a,%ecx
  401165:	74 05                	je     40116c <phase_5+0x3f>
  401167:	e8 08 05 00 00       	callq  401674 <explode_bomb>
  40116c:	5b                   	pop    %rbx
  40116d:	c3                   	retq   

000000000040116e <phase_6>:
  40116e:	41 55                	push   %r13
  401170:	41 54                	push   %r12
  401172:	55                   	push   %rbp
  401173:	53                   	push   %rbx
  401174:	48 83 ec 68          	sub    $0x68,%rsp
  401178:	64 48 8b 04 25 28 00 	mov    %fs:0x28,%rax
  40117f:	00 00 
  401181:	48 89 44 24 58       	mov    %rax,0x58(%rsp)
  401186:	31 c0                	xor    %eax,%eax
  401188:	48 89 e6             	mov    %rsp,%rsi
  40118b:	e8 1a 05 00 00       	callq  4016aa <read_six_numbers>
  401190:	49 89 e4             	mov    %rsp,%r12
  401193:	41 bd 00 00 00 00    	mov    $0x0,%r13d
  401199:	4c 89 e5             	mov    %r12,%rbp
  40119c:	41 8b 04 24          	mov    (%r12),%eax
  4011a0:	83 e8 01             	sub    $0x1,%eax
  4011a3:	83 f8 05             	cmp    $0x5,%eax
  4011a6:	76 05                	jbe    4011ad <phase_6+0x3f>
  4011a8:	e8 c7 04 00 00       	callq  401674 <explode_bomb>
  4011ad:	41 83 c5 01          	add    $0x1,%r13d
  4011b1:	41 83 fd 06          	cmp    $0x6,%r13d
  4011b5:	74 3d                	je     4011f4 <phase_6+0x86>
  4011b7:	44 89 eb             	mov    %r13d,%ebx
  4011ba:	48 63 c3             	movslq %ebx,%rax
  4011bd:	8b 04 84             	mov    (%rsp,%rax,4),%eax
  4011c0:	39 45 00             	cmp    %eax,0x0(%rbp)
  4011c3:	75 05                	jne    4011ca <phase_6+0x5c>
  4011c5:	e8 aa 04 00 00       	callq  401674 <explode_bomb>
  4011ca:	83 c3 01             	add    $0x1,%ebx
  4011cd:	83 fb 05             	cmp    $0x5,%ebx
  4011d0:	7e e8                	jle    4011ba <phase_6+0x4c>
  4011d2:	49 83 c4 04          	add    $0x4,%r12
  4011d6:	eb c1                	jmp    401199 <phase_6+0x2b>
  4011d8:	48 8b 52 08          	mov    0x8(%rdx),%rdx
  4011dc:	83 c0 01             	add    $0x1,%eax
  4011df:	39 c8                	cmp    %ecx,%eax
  4011e1:	75 f5                	jne    4011d8 <phase_6+0x6a>
  4011e3:	48 89 54 74 20       	mov    %rdx,0x20(%rsp,%rsi,2)
  4011e8:	48 83 c6 04          	add    $0x4,%rsi
  4011ec:	48 83 fe 18          	cmp    $0x18,%rsi
  4011f0:	75 07                	jne    4011f9 <phase_6+0x8b>
  4011f2:	eb 19                	jmp    40120d <phase_6+0x9f>
  4011f4:	be 00 00 00 00       	mov    $0x0,%esi
  4011f9:	8b 0c 34             	mov    (%rsp,%rsi,1),%ecx
  4011fc:	b8 01 00 00 00       	mov    $0x1,%eax
  401201:	ba f0 42 60 00       	mov    $0x6042f0,%edx
  401206:	83 f9 01             	cmp    $0x1,%ecx
  401209:	7f cd                	jg     4011d8 <phase_6+0x6a>
  40120b:	eb d6                	jmp    4011e3 <phase_6+0x75>
  40120d:	48 8b 5c 24 20       	mov    0x20(%rsp),%rbx
  401212:	48 8d 44 24 20       	lea    0x20(%rsp),%rax
  401217:	48 8d 74 24 48       	lea    0x48(%rsp),%rsi
  40121c:	48 89 d9             	mov    %rbx,%rcx
  40121f:	48 8b 50 08          	mov    0x8(%rax),%rdx
  401223:	48 89 51 08          	mov    %rdx,0x8(%rcx)
  401227:	48 83 c0 08          	add    $0x8,%rax
  40122b:	48 89 d1             	mov    %rdx,%rcx
  40122e:	48 39 f0             	cmp    %rsi,%rax
  401231:	75 ec                	jne    40121f <phase_6+0xb1>
  401233:	48 c7 42 08 00 00 00 	movq   $0x0,0x8(%rdx)
  40123a:	00 
  40123b:	bd 05 00 00 00       	mov    $0x5,%ebp
  401240:	48 8b 43 08          	mov    0x8(%rbx),%rax
  401244:	8b 00                	mov    (%rax),%eax
  401246:	39 03                	cmp    %eax,(%rbx)
  401248:	7d 05                	jge    40124f <phase_6+0xe1>
  40124a:	e8 25 04 00 00       	callq  401674 <explode_bomb>
  40124f:	48 8b 5b 08          	mov    0x8(%rbx),%rbx
  401253:	83 ed 01             	sub    $0x1,%ebp
  401256:	75 e8                	jne    401240 <phase_6+0xd2>
  401258:	48 8b 44 24 58       	mov    0x58(%rsp),%rax
  40125d:	64 48 33 04 25 28 00 	xor    %fs:0x28,%rax
  401264:	00 00 
  401266:	74 05                	je     40126d <phase_6+0xff>
  401268:	e8 23 f9 ff ff       	callq  400b90 <__stack_chk_fail@plt>
  40126d:	48 83 c4 68          	add    $0x68,%rsp
  401271:	5b                   	pop    %rbx
  401272:	5d                   	pop    %rbp
  401273:	41 5c                	pop    %r12
  401275:	41 5d                	pop    %r13
  401277:	c3                   	retq   

0000000000401278 <fun7>:
  401278:	48 83 ec 08          	sub    $0x8,%rsp
  40127c:	48 85 ff             	test   %rdi,%rdi
  40127f:	74 2b                	je     4012ac <fun7+0x34>
  401281:	8b 17                	mov    (%rdi),%edx
  401283:	39 f2                	cmp    %esi,%edx
  401285:	7e 0d                	jle    401294 <fun7+0x1c>
  401287:	48 8b 7f 08          	mov    0x8(%rdi),%rdi
  40128b:	e8 e8 ff ff ff       	callq  401278 <fun7>
  401290:	01 c0                	add    %eax,%eax
  401292:	eb 1d                	jmp    4012b1 <fun7+0x39>
  401294:	b8 00 00 00 00       	mov    $0x0,%eax
  401299:	39 f2                	cmp    %esi,%edx
  40129b:	74 14                	je     4012b1 <fun7+0x39>
  40129d:	48 8b 7f 10          	mov    0x10(%rdi),%rdi
  4012a1:	e8 d2 ff ff ff       	callq  401278 <fun7>
  4012a6:	8d 44 00 01          	lea    0x1(%rax,%rax,1),%eax
  4012aa:	eb 05                	jmp    4012b1 <fun7+0x39>
  4012ac:	b8 ff ff ff ff       	mov    $0xffffffff,%eax
  4012b1:	48 83 c4 08          	add    $0x8,%rsp
  4012b5:	c3                   	retq   

00000000004012b6 <secret_phase>:
  4012b6:	53                   	push   %rbx
  4012b7:	e8 2d 04 00 00       	callq  4016e9 <read_line>
  4012bc:	ba 0a 00 00 00       	mov    $0xa,%edx
  4012c1:	be 00 00 00 00       	mov    $0x0,%esi
  4012c6:	48 89 c7             	mov    %rax,%rdi
  4012c9:	e8 52 f9 ff ff       	callq  400c20 <strtol@plt>
  4012ce:	48 89 c3             	mov    %rax,%rbx
  4012d1:	8d 40 ff             	lea    -0x1(%rax),%eax
  4012d4:	3d e8 03 00 00       	cmp    $0x3e8,%eax
  4012d9:	76 05                	jbe    4012e0 <secret_phase+0x2a>
  4012db:	e8 94 03 00 00       	callq  401674 <explode_bomb>
  4012e0:	89 de                	mov    %ebx,%esi
  4012e2:	bf 10 41 60 00       	mov    $0x604110,%edi
  4012e7:	e8 8c ff ff ff       	callq  401278 <fun7>
  4012ec:	83 f8 02             	cmp    $0x2,%eax
  4012ef:	74 05                	je     4012f6 <secret_phase+0x40>
  4012f1:	e8 7e 03 00 00       	callq  401674 <explode_bomb>
  4012f6:	bf 68 26 40 00       	mov    $0x402668,%edi
  4012fb:	e8 70 f8 ff ff       	callq  400b70 <puts@plt>
  401300:	e8 0a 05 00 00       	callq  40180f <phase_defused>
  401305:	5b                   	pop    %rbx
  401306:	c3                   	retq   

0000000000401307 <sig_handler>:
  401307:	48 83 ec 08          	sub    $0x8,%rsp
  40130b:	bf 20 27 40 00       	mov    $0x402720,%edi
  401310:	e8 5b f8 ff ff       	callq  400b70 <puts@plt>
  401315:	bf 03 00 00 00       	mov    $0x3,%edi
  40131a:	e8 91 f9 ff ff       	callq  400cb0 <sleep@plt>
  40131f:	be e9 28 40 00       	mov    $0x4028e9,%esi
  401324:	bf 01 00 00 00       	mov    $0x1,%edi
  401329:	b8 00 00 00 00       	mov    $0x0,%eax
  40132e:	e8 1d f9 ff ff       	callq  400c50 <__printf_chk@plt>
  401333:	48 8b 3d 46 34 20 00 	mov    0x203446(%rip),%rdi        # 604780 <__TMC_END__>
  40133a:	e8 f1 f8 ff ff       	callq  400c30 <fflush@plt>
  40133f:	bf 01 00 00 00       	mov    $0x1,%edi
  401344:	e8 67 f9 ff ff       	callq  400cb0 <sleep@plt>
  401349:	bf f1 28 40 00       	mov    $0x4028f1,%edi
  40134e:	e8 1d f8 ff ff       	callq  400b70 <puts@plt>
  401353:	bf 10 00 00 00       	mov    $0x10,%edi
  401358:	e8 23 f9 ff ff       	callq  400c80 <exit@plt>

000000000040135d <invalid_phase>:
  40135d:	48 83 ec 08          	sub    $0x8,%rsp
  401361:	48 89 fa             	mov    %rdi,%rdx
  401364:	be f9 28 40 00       	mov    $0x4028f9,%esi
  401369:	bf 01 00 00 00       	mov    $0x1,%edi
  40136e:	b8 00 00 00 00       	mov    $0x0,%eax
  401373:	e8 d8 f8 ff ff       	callq  400c50 <__printf_chk@plt>
  401378:	bf 08 00 00 00       	mov    $0x8,%edi
  40137d:	e8 fe f8 ff ff       	callq  400c80 <exit@plt>

0000000000401382 <string_length>:
  401382:	80 3f 00             	cmpb   $0x0,(%rdi)
  401385:	74 13                	je     40139a <string_length+0x18>
  401387:	b8 00 00 00 00       	mov    $0x0,%eax
  40138c:	48 83 c7 01          	add    $0x1,%rdi
  401390:	83 c0 01             	add    $0x1,%eax
  401393:	80 3f 00             	cmpb   $0x0,(%rdi)
  401396:	75 f4                	jne    40138c <string_length+0xa>
  401398:	f3 c3                	repz retq 
  40139a:	b8 00 00 00 00       	mov    $0x0,%eax
  40139f:	c3                   	retq   

00000000004013a0 <strings_not_equal>:
  4013a0:	41 54                	push   %r12
  4013a2:	55                   	push   %rbp
  4013a3:	53                   	push   %rbx
  4013a4:	48 89 fb             	mov    %rdi,%rbx
  4013a7:	48 89 f5             	mov    %rsi,%rbp
  4013aa:	e8 d3 ff ff ff       	callq  401382 <string_length>
  4013af:	41 89 c4             	mov    %eax,%r12d
  4013b2:	48 89 ef             	mov    %rbp,%rdi
  4013b5:	e8 c8 ff ff ff       	callq  401382 <string_length>
  4013ba:	ba 01 00 00 00       	mov    $0x1,%edx
  4013bf:	41 39 c4             	cmp    %eax,%r12d
  4013c2:	75 3c                	jne    401400 <strings_not_equal+0x60>
  4013c4:	0f b6 03             	movzbl (%rbx),%eax
  4013c7:	84 c0                	test   %al,%al
  4013c9:	74 22                	je     4013ed <strings_not_equal+0x4d>
  4013cb:	3a 45 00             	cmp    0x0(%rbp),%al
  4013ce:	74 07                	je     4013d7 <strings_not_equal+0x37>
  4013d0:	eb 22                	jmp    4013f4 <strings_not_equal+0x54>
  4013d2:	3a 45 00             	cmp    0x0(%rbp),%al
  4013d5:	75 24                	jne    4013fb <strings_not_equal+0x5b>
  4013d7:	48 83 c3 01          	add    $0x1,%rbx
  4013db:	48 83 c5 01          	add    $0x1,%rbp
  4013df:	0f b6 03             	movzbl (%rbx),%eax
  4013e2:	84 c0                	test   %al,%al
  4013e4:	75 ec                	jne    4013d2 <strings_not_equal+0x32>
  4013e6:	ba 00 00 00 00       	mov    $0x0,%edx
  4013eb:	eb 13                	jmp    401400 <strings_not_equal+0x60>
  4013ed:	ba 00 00 00 00       	mov    $0x0,%edx
  4013f2:	eb 0c                	jmp    401400 <strings_not_equal+0x60>
  4013f4:	ba 01 00 00 00       	mov    $0x1,%edx
  4013f9:	eb 05                	jmp    401400 <strings_not_equal+0x60>
  4013fb:	ba 01 00 00 00       	mov    $0x1,%edx
  401400:	89 d0                	mov    %edx,%eax
  401402:	5b                   	pop    %rbx
  401403:	5d                   	pop    %rbp
  401404:	41 5c                	pop    %r12
  401406:	c3                   	retq   

0000000000401407 <initialize_bomb>:
  401407:	53                   	push   %rbx
  401408:	48 81 ec 50 20 00 00 	sub    $0x2050,%rsp
  40140f:	64 48 8b 04 25 28 00 	mov    %fs:0x28,%rax
  401416:	00 00 
  401418:	48 89 84 24 48 20 00 	mov    %rax,0x2048(%rsp)
  40141f:	00 
  401420:	31 c0                	xor    %eax,%eax
  401422:	be 07 13 40 00       	mov    $0x401307,%esi
  401427:	bf 02 00 00 00       	mov    $0x2,%edi
  40142c:	e8 bf f7 ff ff       	callq  400bf0 <signal@plt>
  401431:	be 40 00 00 00       	mov    $0x40,%esi
  401436:	48 89 e7             	mov    %rsp,%rdi
  401439:	e8 32 f8 ff ff       	callq  400c70 <gethostname@plt>
  40143e:	85 c0                	test   %eax,%eax
  401440:	75 13                	jne    401455 <initialize_bomb+0x4e>
  401442:	48 8b 3d 37 2f 20 00 	mov    0x202f37(%rip),%rdi        # 604380 <host_table>
  401449:	bb 88 43 60 00       	mov    $0x604388,%ebx
  40144e:	48 85 ff             	test   %rdi,%rdi
  401451:	75 16                	jne    401469 <initialize_bomb+0x62>
  401453:	eb 52                	jmp    4014a7 <initialize_bomb+0xa0>
  401455:	bf 58 27 40 00       	mov    $0x402758,%edi
  40145a:	e8 11 f7 ff ff       	callq  400b70 <puts@plt>
  40145f:	bf 08 00 00 00       	mov    $0x8,%edi
  401464:	e8 17 f8 ff ff       	callq  400c80 <exit@plt>
  401469:	48 89 e6             	mov    %rsp,%rsi
  40146c:	e8 cf f6 ff ff       	callq  400b40 <strcasecmp@plt>
  401471:	85 c0                	test   %eax,%eax
  401473:	74 46                	je     4014bb <initialize_bomb+0xb4>
  401475:	48 83 c3 08          	add    $0x8,%rbx
  401479:	48 8b 7b f8          	mov    -0x8(%rbx),%rdi
  40147d:	48 85 ff             	test   %rdi,%rdi
  401480:	75 e7                	jne    401469 <initialize_bomb+0x62>
  401482:	eb 23                	jmp    4014a7 <initialize_bomb+0xa0>
  401484:	48 8d 54 24 40       	lea    0x40(%rsp),%rdx
  401489:	be 0a 29 40 00       	mov    $0x40290a,%esi
  40148e:	bf 01 00 00 00       	mov    $0x1,%edi
  401493:	b8 00 00 00 00       	mov    $0x0,%eax
  401498:	e8 b3 f7 ff ff       	callq  400c50 <__printf_chk@plt>
  40149d:	bf 08 00 00 00       	mov    $0x8,%edi
  4014a2:	e8 d9 f7 ff ff       	callq  400c80 <exit@plt>
  4014a7:	bf 90 27 40 00       	mov    $0x402790,%edi
  4014ac:	e8 bf f6 ff ff       	callq  400b70 <puts@plt>
  4014b1:	bf 08 00 00 00       	mov    $0x8,%edi
  4014b6:	e8 c5 f7 ff ff       	callq  400c80 <exit@plt>
  4014bb:	48 8d 7c 24 40       	lea    0x40(%rsp),%rdi
  4014c0:	e8 49 0d 00 00       	callq  40220e <init_driver>
  4014c5:	85 c0                	test   %eax,%eax
  4014c7:	78 bb                	js     401484 <initialize_bomb+0x7d>
  4014c9:	48 8b 84 24 48 20 00 	mov    0x2048(%rsp),%rax
  4014d0:	00 
  4014d1:	64 48 33 04 25 28 00 	xor    %fs:0x28,%rax
  4014d8:	00 00 
  4014da:	74 05                	je     4014e1 <initialize_bomb+0xda>
  4014dc:	e8 af f6 ff ff       	callq  400b90 <__stack_chk_fail@plt>
  4014e1:	48 81 c4 50 20 00 00 	add    $0x2050,%rsp
  4014e8:	5b                   	pop    %rbx
  4014e9:	c3                   	retq   

00000000004014ea <initialize_bomb_solve>:
  4014ea:	f3 c3                	repz retq 

00000000004014ec <blank_line>:
  4014ec:	55                   	push   %rbp
  4014ed:	53                   	push   %rbx
  4014ee:	48 83 ec 08          	sub    $0x8,%rsp
  4014f2:	48 89 fd             	mov    %rdi,%rbp
  4014f5:	eb 17                	jmp    40150e <blank_line+0x22>
  4014f7:	e8 c4 f7 ff ff       	callq  400cc0 <__ctype_b_loc@plt>
  4014fc:	48 83 c5 01          	add    $0x1,%rbp
  401500:	48 0f be db          	movsbq %bl,%rbx
  401504:	48 8b 00             	mov    (%rax),%rax
  401507:	f6 44 58 01 20       	testb  $0x20,0x1(%rax,%rbx,2)
  40150c:	74 0f                	je     40151d <blank_line+0x31>
  40150e:	0f b6 5d 00          	movzbl 0x0(%rbp),%ebx
  401512:	84 db                	test   %bl,%bl
  401514:	75 e1                	jne    4014f7 <blank_line+0xb>
  401516:	b8 01 00 00 00       	mov    $0x1,%eax
  40151b:	eb 05                	jmp    401522 <blank_line+0x36>
  40151d:	b8 00 00 00 00       	mov    $0x0,%eax
  401522:	48 83 c4 08          	add    $0x8,%rsp
  401526:	5b                   	pop    %rbx
  401527:	5d                   	pop    %rbp
  401528:	c3                   	retq   

0000000000401529 <skip>:
  401529:	53                   	push   %rbx
  40152a:	48 63 05 7b 32 20 00 	movslq 0x20327b(%rip),%rax        # 6047ac <num_input_strings>
  401531:	48 8d 3c 80          	lea    (%rax,%rax,4),%rdi
  401535:	48 c1 e7 04          	shl    $0x4,%rdi
  401539:	48 81 c7 c0 47 60 00 	add    $0x6047c0,%rdi
  401540:	48 8b 15 69 32 20 00 	mov    0x203269(%rip),%rdx        # 6047b0 <infile>
  401547:	be 50 00 00 00       	mov    $0x50,%esi
  40154c:	e8 8f f6 ff ff       	callq  400be0 <fgets@plt>
  401551:	48 89 c3             	mov    %rax,%rbx
  401554:	48 85 c0             	test   %rax,%rax
  401557:	74 0c                	je     401565 <skip+0x3c>
  401559:	48 89 c7             	mov    %rax,%rdi
  40155c:	e8 8b ff ff ff       	callq  4014ec <blank_line>
  401561:	85 c0                	test   %eax,%eax
  401563:	75 c5                	jne    40152a <skip+0x1>
  401565:	48 89 d8             	mov    %rbx,%rax
  401568:	5b                   	pop    %rbx
  401569:	c3                   	retq   

000000000040156a <send_msg>:
  40156a:	48 81 ec 18 40 00 00 	sub    $0x4018,%rsp
  401571:	41 89 f8             	mov    %edi,%r8d
  401574:	64 48 8b 04 25 28 00 	mov    %fs:0x28,%rax
  40157b:	00 00 
  40157d:	48 89 84 24 08 40 00 	mov    %rax,0x4008(%rsp)
  401584:	00 
  401585:	31 c0                	xor    %eax,%eax
  401587:	8b 35 1f 32 20 00    	mov    0x20321f(%rip),%esi        # 6047ac <num_input_strings>
  40158d:	8d 46 ff             	lea    -0x1(%rsi),%eax
  401590:	48 98                	cltq   
  401592:	48 8d 14 80          	lea    (%rax,%rax,4),%rdx
  401596:	48 c1 e2 04          	shl    $0x4,%rdx
  40159a:	48 81 c2 c0 47 60 00 	add    $0x6047c0,%rdx
  4015a1:	b8 00 00 00 00       	mov    $0x0,%eax
  4015a6:	48 c7 c1 ff ff ff ff 	mov    $0xffffffffffffffff,%rcx
  4015ad:	48 89 d7             	mov    %rdx,%rdi
  4015b0:	f2 ae                	repnz scas %es:(%rdi),%al
  4015b2:	48 f7 d1             	not    %rcx
  4015b5:	48 83 c1 63          	add    $0x63,%rcx
  4015b9:	48 81 f9 00 20 00 00 	cmp    $0x2000,%rcx
  4015c0:	76 19                	jbe    4015db <send_msg+0x71>
  4015c2:	be c8 27 40 00       	mov    $0x4027c8,%esi
  4015c7:	bf 01 00 00 00       	mov    $0x1,%edi
  4015cc:	e8 7f f6 ff ff       	callq  400c50 <__printf_chk@plt>
  4015d1:	bf 08 00 00 00       	mov    $0x8,%edi
  4015d6:	e8 a5 f6 ff ff       	callq  400c80 <exit@plt>
  4015db:	45 85 c0             	test   %r8d,%r8d
  4015de:	41 b9 2c 29 40 00    	mov    $0x40292c,%r9d
  4015e4:	b8 24 29 40 00       	mov    $0x402924,%eax
  4015e9:	4c 0f 45 c8          	cmovne %rax,%r9
  4015ed:	52                   	push   %rdx
  4015ee:	56                   	push   %rsi
  4015ef:	44 8b 05 76 2d 20 00 	mov    0x202d76(%rip),%r8d        # 60436c <bomb_id>
  4015f6:	b9 35 29 40 00       	mov    $0x402935,%ecx
  4015fb:	ba 00 20 00 00       	mov    $0x2000,%edx
  401600:	be 01 00 00 00       	mov    $0x1,%esi
  401605:	48 8d 7c 24 10       	lea    0x10(%rsp),%rdi
  40160a:	b8 00 00 00 00       	mov    $0x0,%eax
  40160f:	e8 bc f6 ff ff       	callq  400cd0 <__sprintf_chk@plt>
  401614:	4c 8d 84 24 10 20 00 	lea    0x2010(%rsp),%r8
  40161b:	00 
  40161c:	b9 00 00 00 00       	mov    $0x0,%ecx
  401621:	48 8d 54 24 10       	lea    0x10(%rsp),%rdx
  401626:	be 50 43 60 00       	mov    $0x604350,%esi
  40162b:	bf 65 43 60 00       	mov    $0x604365,%edi
  401630:	e8 ae 0d 00 00       	callq  4023e3 <driver_post>
  401635:	48 83 c4 10          	add    $0x10,%rsp
  401639:	85 c0                	test   %eax,%eax
  40163b:	79 17                	jns    401654 <send_msg+0xea>
  40163d:	48 8d bc 24 00 20 00 	lea    0x2000(%rsp),%rdi
  401644:	00 
  401645:	e8 26 f5 ff ff       	callq  400b70 <puts@plt>
  40164a:	bf 00 00 00 00       	mov    $0x0,%edi
  40164f:	e8 2c f6 ff ff       	callq  400c80 <exit@plt>
  401654:	48 8b 84 24 08 40 00 	mov    0x4008(%rsp),%rax
  40165b:	00 
  40165c:	64 48 33 04 25 28 00 	xor    %fs:0x28,%rax
  401663:	00 00 
  401665:	74 05                	je     40166c <send_msg+0x102>
  401667:	e8 24 f5 ff ff       	callq  400b90 <__stack_chk_fail@plt>
  40166c:	48 81 c4 18 40 00 00 	add    $0x4018,%rsp
  401673:	c3                   	retq   

0000000000401674 <explode_bomb>:
  401674:	48 83 ec 08          	sub    $0x8,%rsp
  401678:	bf 41 29 40 00       	mov    $0x402941,%edi
  40167d:	e8 ee f4 ff ff       	callq  400b70 <puts@plt>
  401682:	bf 4a 29 40 00       	mov    $0x40294a,%edi
  401687:	e8 e4 f4 ff ff       	callq  400b70 <puts@plt>
  40168c:	bf 00 00 00 00       	mov    $0x0,%edi
  401691:	e8 d4 fe ff ff       	callq  40156a <send_msg>
  401696:	bf f0 27 40 00       	mov    $0x4027f0,%edi
  40169b:	e8 d0 f4 ff ff       	callq  400b70 <puts@plt>
  4016a0:	bf 08 00 00 00       	mov    $0x8,%edi
  4016a5:	e8 d6 f5 ff ff       	callq  400c80 <exit@plt>

00000000004016aa <read_six_numbers>:
  4016aa:	48 83 ec 08          	sub    $0x8,%rsp
  4016ae:	48 89 f2             	mov    %rsi,%rdx
  4016b1:	48 8d 4e 04          	lea    0x4(%rsi),%rcx
  4016b5:	48 8d 46 14          	lea    0x14(%rsi),%rax
  4016b9:	50                   	push   %rax
  4016ba:	48 8d 46 10          	lea    0x10(%rsi),%rax
  4016be:	50                   	push   %rax
  4016bf:	4c 8d 4e 0c          	lea    0xc(%rsi),%r9
  4016c3:	4c 8d 46 08          	lea    0x8(%rsi),%r8
  4016c7:	be 61 29 40 00       	mov    $0x402961,%esi
  4016cc:	b8 00 00 00 00       	mov    $0x0,%eax
  4016d1:	e8 6a f5 ff ff       	callq  400c40 <__isoc99_sscanf@plt>
  4016d6:	48 83 c4 10          	add    $0x10,%rsp
  4016da:	83 f8 05             	cmp    $0x5,%eax
  4016dd:	7f 05                	jg     4016e4 <read_six_numbers+0x3a>
  4016df:	e8 90 ff ff ff       	callq  401674 <explode_bomb>
  4016e4:	48 83 c4 08          	add    $0x8,%rsp
  4016e8:	c3                   	retq   

00000000004016e9 <read_line>:
  4016e9:	48 83 ec 08          	sub    $0x8,%rsp
  4016ed:	b8 00 00 00 00       	mov    $0x0,%eax
  4016f2:	e8 32 fe ff ff       	callq  401529 <skip>
  4016f7:	48 85 c0             	test   %rax,%rax
  4016fa:	75 6e                	jne    40176a <read_line+0x81>
  4016fc:	48 8b 05 8d 30 20 00 	mov    0x20308d(%rip),%rax        # 604790 <stdin@@GLIBC_2.2.5>
  401703:	48 39 05 a6 30 20 00 	cmp    %rax,0x2030a6(%rip)        # 6047b0 <infile>
  40170a:	75 14                	jne    401720 <read_line+0x37>
  40170c:	bf 73 29 40 00       	mov    $0x402973,%edi
  401711:	e8 5a f4 ff ff       	callq  400b70 <puts@plt>
  401716:	bf 08 00 00 00       	mov    $0x8,%edi
  40171b:	e8 60 f5 ff ff       	callq  400c80 <exit@plt>
  401720:	bf 91 29 40 00       	mov    $0x402991,%edi
  401725:	e8 06 f4 ff ff       	callq  400b30 <getenv@plt>
  40172a:	48 85 c0             	test   %rax,%rax
  40172d:	74 0a                	je     401739 <read_line+0x50>
  40172f:	bf 00 00 00 00       	mov    $0x0,%edi
  401734:	e8 47 f5 ff ff       	callq  400c80 <exit@plt>
  401739:	48 8b 05 50 30 20 00 	mov    0x203050(%rip),%rax        # 604790 <stdin@@GLIBC_2.2.5>
  401740:	48 89 05 69 30 20 00 	mov    %rax,0x203069(%rip)        # 6047b0 <infile>
  401747:	b8 00 00 00 00       	mov    $0x0,%eax
  40174c:	e8 d8 fd ff ff       	callq  401529 <skip>
  401751:	48 85 c0             	test   %rax,%rax
  401754:	75 14                	jne    40176a <read_line+0x81>
  401756:	bf 73 29 40 00       	mov    $0x402973,%edi
  40175b:	e8 10 f4 ff ff       	callq  400b70 <puts@plt>
  401760:	bf 00 00 00 00       	mov    $0x0,%edi
  401765:	e8 16 f5 ff ff       	callq  400c80 <exit@plt>
  40176a:	8b 35 3c 30 20 00    	mov    0x20303c(%rip),%esi        # 6047ac <num_input_strings>
  401770:	48 63 c6             	movslq %esi,%rax
  401773:	48 8d 14 80          	lea    (%rax,%rax,4),%rdx
  401777:	48 c1 e2 04          	shl    $0x4,%rdx
  40177b:	48 81 c2 c0 47 60 00 	add    $0x6047c0,%rdx
  401782:	b8 00 00 00 00       	mov    $0x0,%eax
  401787:	48 c7 c1 ff ff ff ff 	mov    $0xffffffffffffffff,%rcx
  40178e:	48 89 d7             	mov    %rdx,%rdi
  401791:	f2 ae                	repnz scas %es:(%rdi),%al
  401793:	48 f7 d1             	not    %rcx
  401796:	48 83 e9 01          	sub    $0x1,%rcx
  40179a:	83 f9 4e             	cmp    $0x4e,%ecx
  40179d:	7e 46                	jle    4017e5 <read_line+0xfc>
  40179f:	bf 9c 29 40 00       	mov    $0x40299c,%edi
  4017a4:	e8 c7 f3 ff ff       	callq  400b70 <puts@plt>
  4017a9:	8b 05 fd 2f 20 00    	mov    0x202ffd(%rip),%eax        # 6047ac <num_input_strings>
  4017af:	8d 50 01             	lea    0x1(%rax),%edx
  4017b2:	89 15 f4 2f 20 00    	mov    %edx,0x202ff4(%rip)        # 6047ac <num_input_strings>
  4017b8:	48 98                	cltq   
  4017ba:	48 6b c0 50          	imul   $0x50,%rax,%rax
  4017be:	48 bf 2a 2a 2a 74 72 	movabs $0x636e7572742a2a2a,%rdi
  4017c5:	75 6e 63 
  4017c8:	48 89 b8 c0 47 60 00 	mov    %rdi,0x6047c0(%rax)
  4017cf:	48 bf 61 74 65 64 2a 	movabs $0x2a2a2a64657461,%rdi
  4017d6:	2a 2a 00 
  4017d9:	48 89 b8 c8 47 60 00 	mov    %rdi,0x6047c8(%rax)
  4017e0:	e8 8f fe ff ff       	callq  401674 <explode_bomb>
  4017e5:	83 e9 01             	sub    $0x1,%ecx
  4017e8:	48 63 c9             	movslq %ecx,%rcx
  4017eb:	48 63 c6             	movslq %esi,%rax
  4017ee:	48 8d 04 80          	lea    (%rax,%rax,4),%rax
  4017f2:	48 c1 e0 04          	shl    $0x4,%rax
  4017f6:	c6 84 01 c0 47 60 00 	movb   $0x0,0x6047c0(%rcx,%rax,1)
  4017fd:	00 
  4017fe:	8d 46 01             	lea    0x1(%rsi),%eax
  401801:	89 05 a5 2f 20 00    	mov    %eax,0x202fa5(%rip)        # 6047ac <num_input_strings>
  401807:	48 89 d0             	mov    %rdx,%rax
  40180a:	48 83 c4 08          	add    $0x8,%rsp
  40180e:	c3                   	retq   

000000000040180f <phase_defused>:
  40180f:	48 83 ec 78          	sub    $0x78,%rsp
  401813:	64 48 8b 04 25 28 00 	mov    %fs:0x28,%rax
  40181a:	00 00 
  40181c:	48 89 44 24 68       	mov    %rax,0x68(%rsp)
  401821:	31 c0                	xor    %eax,%eax
  401823:	bf 01 00 00 00       	mov    $0x1,%edi
  401828:	e8 3d fd ff ff       	callq  40156a <send_msg>
  40182d:	83 3d 78 2f 20 00 06 	cmpl   $0x6,0x202f78(%rip)        # 6047ac <num_input_strings>
  401834:	75 6d                	jne    4018a3 <phase_defused+0x94>
  401836:	4c 8d 44 24 10       	lea    0x10(%rsp),%r8
  40183b:	48 8d 4c 24 0c       	lea    0xc(%rsp),%rcx
  401840:	48 8d 54 24 08       	lea    0x8(%rsp),%rdx
  401845:	be b7 29 40 00       	mov    $0x4029b7,%esi
  40184a:	bf b0 48 60 00       	mov    $0x6048b0,%edi
  40184f:	b8 00 00 00 00       	mov    $0x0,%eax
  401854:	e8 e7 f3 ff ff       	callq  400c40 <__isoc99_sscanf@plt>
  401859:	83 f8 03             	cmp    $0x3,%eax
  40185c:	75 31                	jne    40188f <phase_defused+0x80>
  40185e:	be c0 29 40 00       	mov    $0x4029c0,%esi
  401863:	48 8d 7c 24 10       	lea    0x10(%rsp),%rdi
  401868:	e8 33 fb ff ff       	callq  4013a0 <strings_not_equal>
  40186d:	85 c0                	test   %eax,%eax
  40186f:	75 1e                	jne    40188f <phase_defused+0x80>
  401871:	bf 18 28 40 00       	mov    $0x402818,%edi
  401876:	e8 f5 f2 ff ff       	callq  400b70 <puts@plt>
  40187b:	bf 40 28 40 00       	mov    $0x402840,%edi
  401880:	e8 eb f2 ff ff       	callq  400b70 <puts@plt>
  401885:	b8 00 00 00 00       	mov    $0x0,%eax
  40188a:	e8 27 fa ff ff       	callq  4012b6 <secret_phase>
  40188f:	bf 78 28 40 00       	mov    $0x402878,%edi
  401894:	e8 d7 f2 ff ff       	callq  400b70 <puts@plt>
  401899:	bf a8 28 40 00       	mov    $0x4028a8,%edi
  40189e:	e8 cd f2 ff ff       	callq  400b70 <puts@plt>
  4018a3:	48 8b 44 24 68       	mov    0x68(%rsp),%rax
  4018a8:	64 48 33 04 25 28 00 	xor    %fs:0x28,%rax
  4018af:	00 00 
  4018b1:	74 05                	je     4018b8 <phase_defused+0xa9>
  4018b3:	e8 d8 f2 ff ff       	callq  400b90 <__stack_chk_fail@plt>
  4018b8:	48 83 c4 78          	add    $0x78,%rsp
  4018bc:	c3                   	retq   

00000000004018bd <sigalrm_handler>:
  4018bd:	48 83 ec 08          	sub    $0x8,%rsp
  4018c1:	b9 00 00 00 00       	mov    $0x0,%ecx
  4018c6:	ba 48 2a 40 00       	mov    $0x402a48,%edx
  4018cb:	be 01 00 00 00       	mov    $0x1,%esi
  4018d0:	48 8b 3d c9 2e 20 00 	mov    0x202ec9(%rip),%rdi        # 6047a0 <stderr@@GLIBC_2.2.5>
  4018d7:	b8 00 00 00 00       	mov    $0x0,%eax
  4018dc:	e8 bf f3 ff ff       	callq  400ca0 <__fprintf_chk@plt>
  4018e1:	bf 01 00 00 00       	mov    $0x1,%edi
  4018e6:	e8 95 f3 ff ff       	callq  400c80 <exit@plt>

00000000004018eb <rio_readlineb>:
  4018eb:	41 56                	push   %r14
  4018ed:	41 55                	push   %r13
  4018ef:	41 54                	push   %r12
  4018f1:	55                   	push   %rbp
  4018f2:	53                   	push   %rbx
  4018f3:	48 83 ec 10          	sub    $0x10,%rsp
  4018f7:	48 89 fb             	mov    %rdi,%rbx
  4018fa:	49 89 f5             	mov    %rsi,%r13
  4018fd:	49 89 d6             	mov    %rdx,%r14
  401900:	64 48 8b 04 25 28 00 	mov    %fs:0x28,%rax
  401907:	00 00 
  401909:	48 89 44 24 08       	mov    %rax,0x8(%rsp)
  40190e:	31 c0                	xor    %eax,%eax
  401910:	41 bc 01 00 00 00    	mov    $0x1,%r12d
  401916:	48 8d 6f 10          	lea    0x10(%rdi),%rbp
  40191a:	48 83 fa 01          	cmp    $0x1,%rdx
  40191e:	77 2c                	ja     40194c <rio_readlineb+0x61>
  401920:	eb 6d                	jmp    40198f <rio_readlineb+0xa4>
  401922:	ba 00 20 00 00       	mov    $0x2000,%edx
  401927:	48 89 ee             	mov    %rbp,%rsi
  40192a:	8b 3b                	mov    (%rbx),%edi
  40192c:	e8 8f f2 ff ff       	callq  400bc0 <read@plt>
  401931:	89 43 04             	mov    %eax,0x4(%rbx)
  401934:	85 c0                	test   %eax,%eax
  401936:	79 0c                	jns    401944 <rio_readlineb+0x59>
  401938:	e8 13 f2 ff ff       	callq  400b50 <__errno_location@plt>
  40193d:	83 38 04             	cmpl   $0x4,(%rax)
  401940:	74 0a                	je     40194c <rio_readlineb+0x61>
  401942:	eb 6c                	jmp    4019b0 <rio_readlineb+0xc5>
  401944:	85 c0                	test   %eax,%eax
  401946:	74 71                	je     4019b9 <rio_readlineb+0xce>
  401948:	48 89 6b 08          	mov    %rbp,0x8(%rbx)
  40194c:	8b 43 04             	mov    0x4(%rbx),%eax
  40194f:	85 c0                	test   %eax,%eax
  401951:	7e cf                	jle    401922 <rio_readlineb+0x37>
  401953:	48 8b 53 08          	mov    0x8(%rbx),%rdx
  401957:	0f b6 0a             	movzbl (%rdx),%ecx
  40195a:	88 4c 24 07          	mov    %cl,0x7(%rsp)
  40195e:	48 83 c2 01          	add    $0x1,%rdx
  401962:	48 89 53 08          	mov    %rdx,0x8(%rbx)
  401966:	83 e8 01             	sub    $0x1,%eax
  401969:	89 43 04             	mov    %eax,0x4(%rbx)
  40196c:	49 83 c5 01          	add    $0x1,%r13
  401970:	41 88 4d ff          	mov    %cl,-0x1(%r13)
  401974:	80 f9 0a             	cmp    $0xa,%cl
  401977:	75 0a                	jne    401983 <rio_readlineb+0x98>
  401979:	eb 14                	jmp    40198f <rio_readlineb+0xa4>
  40197b:	41 83 fc 01          	cmp    $0x1,%r12d
  40197f:	75 0e                	jne    40198f <rio_readlineb+0xa4>
  401981:	eb 16                	jmp    401999 <rio_readlineb+0xae>
  401983:	41 83 c4 01          	add    $0x1,%r12d
  401987:	49 63 c4             	movslq %r12d,%rax
  40198a:	4c 39 f0             	cmp    %r14,%rax
  40198d:	72 bd                	jb     40194c <rio_readlineb+0x61>
  40198f:	41 c6 45 00 00       	movb   $0x0,0x0(%r13)
  401994:	49 63 c4             	movslq %r12d,%rax
  401997:	eb 05                	jmp    40199e <rio_readlineb+0xb3>
  401999:	b8 00 00 00 00       	mov    $0x0,%eax
  40199e:	48 8b 4c 24 08       	mov    0x8(%rsp),%rcx
  4019a3:	64 48 33 0c 25 28 00 	xor    %fs:0x28,%rcx
  4019aa:	00 00 
  4019ac:	74 22                	je     4019d0 <rio_readlineb+0xe5>
  4019ae:	eb 1b                	jmp    4019cb <rio_readlineb+0xe0>
  4019b0:	48 c7 c0 ff ff ff ff 	mov    $0xffffffffffffffff,%rax
  4019b7:	eb 05                	jmp    4019be <rio_readlineb+0xd3>
  4019b9:	b8 00 00 00 00       	mov    $0x0,%eax
  4019be:	85 c0                	test   %eax,%eax
  4019c0:	74 b9                	je     40197b <rio_readlineb+0x90>
  4019c2:	48 c7 c0 ff ff ff ff 	mov    $0xffffffffffffffff,%rax
  4019c9:	eb d3                	jmp    40199e <rio_readlineb+0xb3>
  4019cb:	e8 c0 f1 ff ff       	callq  400b90 <__stack_chk_fail@plt>
  4019d0:	48 83 c4 10          	add    $0x10,%rsp
  4019d4:	5b                   	pop    %rbx
  4019d5:	5d                   	pop    %rbp
  4019d6:	41 5c                	pop    %r12
  4019d8:	41 5d                	pop    %r13
  4019da:	41 5e                	pop    %r14
  4019dc:	c3                   	retq   

00000000004019dd <submitr>:
  4019dd:	41 57                	push   %r15
  4019df:	41 56                	push   %r14
  4019e1:	41 55                	push   %r13
  4019e3:	41 54                	push   %r12
  4019e5:	55                   	push   %rbp
  4019e6:	53                   	push   %rbx
  4019e7:	48 81 ec 68 a0 00 00 	sub    $0xa068,%rsp
  4019ee:	49 89 fd             	mov    %rdi,%r13
  4019f1:	89 f5                	mov    %esi,%ebp
  4019f3:	48 89 14 24          	mov    %rdx,(%rsp)
  4019f7:	48 89 4c 24 08       	mov    %rcx,0x8(%rsp)
  4019fc:	4c 89 44 24 18       	mov    %r8,0x18(%rsp)
  401a01:	4c 89 4c 24 10       	mov    %r9,0x10(%rsp)
  401a06:	48 8b 9c 24 a0 a0 00 	mov    0xa0a0(%rsp),%rbx
  401a0d:	00 
  401a0e:	4c 8b bc 24 a8 a0 00 	mov    0xa0a8(%rsp),%r15
  401a15:	00 
  401a16:	64 48 8b 04 25 28 00 	mov    %fs:0x28,%rax
  401a1d:	00 00 
  401a1f:	48 89 84 24 58 a0 00 	mov    %rax,0xa058(%rsp)
  401a26:	00 
  401a27:	31 c0                	xor    %eax,%eax
  401a29:	c7 44 24 2c 00 00 00 	movl   $0x0,0x2c(%rsp)
  401a30:	00 
  401a31:	ba 00 00 00 00       	mov    $0x0,%edx
  401a36:	be 01 00 00 00       	mov    $0x1,%esi
  401a3b:	bf 02 00 00 00       	mov    $0x2,%edi
  401a40:	e8 9b f2 ff ff       	callq  400ce0 <socket@plt>
  401a45:	85 c0                	test   %eax,%eax
  401a47:	79 50                	jns    401a99 <submitr+0xbc>
  401a49:	48 b8 45 72 72 6f 72 	movabs $0x43203a726f727245,%rax
  401a50:	3a 20 43 
  401a53:	49 89 07             	mov    %rax,(%r15)
  401a56:	48 b8 6c 69 65 6e 74 	movabs $0x6e7520746e65696c,%rax
  401a5d:	20 75 6e 
  401a60:	49 89 47 08          	mov    %rax,0x8(%r15)
  401a64:	48 b8 61 62 6c 65 20 	movabs $0x206f7420656c6261,%rax
  401a6b:	74 6f 20 
  401a6e:	49 89 47 10          	mov    %rax,0x10(%r15)
  401a72:	48 b8 63 72 65 61 74 	movabs $0x7320657461657263,%rax
  401a79:	65 20 73 
  401a7c:	49 89 47 18          	mov    %rax,0x18(%r15)
  401a80:	41 c7 47 20 6f 63 6b 	movl   $0x656b636f,0x20(%r15)
  401a87:	65 
  401a88:	66 41 c7 47 24 74 00 	movw   $0x74,0x24(%r15)
  401a8f:	b8 ff ff ff ff       	mov    $0xffffffff,%eax
  401a94:	e9 12 06 00 00       	jmpq   4020ab <submitr+0x6ce>
  401a99:	41 89 c4             	mov    %eax,%r12d
  401a9c:	4c 89 ef             	mov    %r13,%rdi
  401a9f:	e8 5c f1 ff ff       	callq  400c00 <gethostbyname@plt>
  401aa4:	48 85 c0             	test   %rax,%rax
  401aa7:	75 6b                	jne    401b14 <submitr+0x137>
  401aa9:	48 b8 45 72 72 6f 72 	movabs $0x44203a726f727245,%rax
  401ab0:	3a 20 44 
  401ab3:	49 89 07             	mov    %rax,(%r15)
  401ab6:	48 b8 4e 53 20 69 73 	movabs $0x6e7520736920534e,%rax
  401abd:	20 75 6e 
  401ac0:	49 89 47 08          	mov    %rax,0x8(%r15)
  401ac4:	48 b8 61 62 6c 65 20 	movabs $0x206f7420656c6261,%rax
  401acb:	74 6f 20 
  401ace:	49 89 47 10          	mov    %rax,0x10(%r15)
  401ad2:	48 b8 72 65 73 6f 6c 	movabs $0x2065766c6f736572,%rax
  401ad9:	76 65 20 
  401adc:	49 89 47 18          	mov    %rax,0x18(%r15)
  401ae0:	48 b8 73 65 72 76 65 	movabs $0x6120726576726573,%rax
  401ae7:	72 20 61 
  401aea:	49 89 47 20          	mov    %rax,0x20(%r15)
  401aee:	41 c7 47 28 64 64 72 	movl   $0x65726464,0x28(%r15)
  401af5:	65 
  401af6:	66 41 c7 47 2c 73 73 	movw   $0x7373,0x2c(%r15)
  401afd:	41 c6 47 2e 00       	movb   $0x0,0x2e(%r15)
  401b02:	44 89 e7             	mov    %r12d,%edi
  401b05:	e8 a6 f0 ff ff       	callq  400bb0 <close@plt>
  401b0a:	b8 ff ff ff ff       	mov    $0xffffffff,%eax
  401b0f:	e9 97 05 00 00       	jmpq   4020ab <submitr+0x6ce>
  401b14:	48 c7 44 24 30 00 00 	movq   $0x0,0x30(%rsp)
  401b1b:	00 00 
  401b1d:	48 c7 44 24 38 00 00 	movq   $0x0,0x38(%rsp)
  401b24:	00 00 
  401b26:	66 c7 44 24 30 02 00 	movw   $0x2,0x30(%rsp)
  401b2d:	48 63 50 14          	movslq 0x14(%rax),%rdx
  401b31:	48 8b 40 18          	mov    0x18(%rax),%rax
  401b35:	48 8d 7c 24 34       	lea    0x34(%rsp),%rdi
  401b3a:	b9 0c 00 00 00       	mov    $0xc,%ecx
  401b3f:	48 8b 30             	mov    (%rax),%rsi
  401b42:	e8 c9 f0 ff ff       	callq  400c10 <__memmove_chk@plt>
  401b47:	66 c1 cd 08          	ror    $0x8,%bp
  401b4b:	66 89 6c 24 32       	mov    %bp,0x32(%rsp)
  401b50:	ba 10 00 00 00       	mov    $0x10,%edx
  401b55:	48 8d 74 24 30       	lea    0x30(%rsp),%rsi
  401b5a:	44 89 e7             	mov    %r12d,%edi
  401b5d:	e8 2e f1 ff ff       	callq  400c90 <connect@plt>
  401b62:	85 c0                	test   %eax,%eax
  401b64:	79 5d                	jns    401bc3 <submitr+0x1e6>
  401b66:	48 b8 45 72 72 6f 72 	movabs $0x55203a726f727245,%rax
  401b6d:	3a 20 55 
  401b70:	49 89 07             	mov    %rax,(%r15)
  401b73:	48 b8 6e 61 62 6c 65 	movabs $0x6f7420656c62616e,%rax
  401b7a:	20 74 6f 
  401b7d:	49 89 47 08          	mov    %rax,0x8(%r15)
  401b81:	48 b8 20 63 6f 6e 6e 	movabs $0x7463656e6e6f6320,%rax
  401b88:	65 63 74 
  401b8b:	49 89 47 10          	mov    %rax,0x10(%r15)
  401b8f:	48 b8 20 74 6f 20 74 	movabs $0x20656874206f7420,%rax
  401b96:	68 65 20 
  401b99:	49 89 47 18          	mov    %rax,0x18(%r15)
  401b9d:	41 c7 47 20 73 65 72 	movl   $0x76726573,0x20(%r15)
  401ba4:	76 
  401ba5:	66 41 c7 47 24 65 72 	movw   $0x7265,0x24(%r15)
  401bac:	41 c6 47 26 00       	movb   $0x0,0x26(%r15)
  401bb1:	44 89 e7             	mov    %r12d,%edi
  401bb4:	e8 f7 ef ff ff       	callq  400bb0 <close@plt>
  401bb9:	b8 ff ff ff ff       	mov    $0xffffffff,%eax
  401bbe:	e9 e8 04 00 00       	jmpq   4020ab <submitr+0x6ce>
  401bc3:	49 c7 c1 ff ff ff ff 	mov    $0xffffffffffffffff,%r9
  401bca:	b8 00 00 00 00       	mov    $0x0,%eax
  401bcf:	4c 89 c9             	mov    %r9,%rcx
  401bd2:	48 89 df             	mov    %rbx,%rdi
  401bd5:	f2 ae                	repnz scas %es:(%rdi),%al
  401bd7:	48 f7 d1             	not    %rcx
  401bda:	48 89 ce             	mov    %rcx,%rsi
  401bdd:	4c 89 c9             	mov    %r9,%rcx
  401be0:	48 8b 3c 24          	mov    (%rsp),%rdi
  401be4:	f2 ae                	repnz scas %es:(%rdi),%al
  401be6:	49 89 c8             	mov    %rcx,%r8
  401be9:	4c 89 c9             	mov    %r9,%rcx
  401bec:	48 8b 7c 24 08       	mov    0x8(%rsp),%rdi
  401bf1:	f2 ae                	repnz scas %es:(%rdi),%al
  401bf3:	48 f7 d1             	not    %rcx
  401bf6:	48 89 ca             	mov    %rcx,%rdx
  401bf9:	4c 89 c9             	mov    %r9,%rcx
  401bfc:	48 8b 7c 24 10       	mov    0x10(%rsp),%rdi
  401c01:	f2 ae                	repnz scas %es:(%rdi),%al
  401c03:	4c 29 c2             	sub    %r8,%rdx
  401c06:	48 29 ca             	sub    %rcx,%rdx
  401c09:	48 8d 44 76 fd       	lea    -0x3(%rsi,%rsi,2),%rax
  401c0e:	48 8d 44 02 7b       	lea    0x7b(%rdx,%rax,1),%rax
  401c13:	48 3d 00 20 00 00    	cmp    $0x2000,%rax
  401c19:	76 73                	jbe    401c8e <submitr+0x2b1>
  401c1b:	48 b8 45 72 72 6f 72 	movabs $0x52203a726f727245,%rax
  401c22:	3a 20 52 
  401c25:	49 89 07             	mov    %rax,(%r15)
  401c28:	48 b8 65 73 75 6c 74 	movabs $0x747320746c757365,%rax
  401c2f:	20 73 74 
  401c32:	49 89 47 08          	mov    %rax,0x8(%r15)
  401c36:	48 b8 72 69 6e 67 20 	movabs $0x6f6f7420676e6972,%rax
  401c3d:	74 6f 6f 
  401c40:	49 89 47 10          	mov    %rax,0x10(%r15)
  401c44:	48 b8 20 6c 61 72 67 	movabs $0x202e656772616c20,%rax
  401c4b:	65 2e 20 
  401c4e:	49 89 47 18          	mov    %rax,0x18(%r15)
  401c52:	48 b8 49 6e 63 72 65 	movabs $0x6573616572636e49,%rax
  401c59:	61 73 65 
  401c5c:	49 89 47 20          	mov    %rax,0x20(%r15)
  401c60:	48 b8 20 53 55 42 4d 	movabs $0x5254494d42555320,%rax
  401c67:	49 54 52 
  401c6a:	49 89 47 28          	mov    %rax,0x28(%r15)
  401c6e:	48 b8 5f 4d 41 58 42 	movabs $0x46554258414d5f,%rax
  401c75:	55 46 00 
  401c78:	49 89 47 30          	mov    %rax,0x30(%r15)
  401c7c:	44 89 e7             	mov    %r12d,%edi
  401c7f:	e8 2c ef ff ff       	callq  400bb0 <close@plt>
  401c84:	b8 ff ff ff ff       	mov    $0xffffffff,%eax
  401c89:	e9 1d 04 00 00       	jmpq   4020ab <submitr+0x6ce>
  401c8e:	48 8d 94 24 50 40 00 	lea    0x4050(%rsp),%rdx
  401c95:	00 
  401c96:	b9 00 04 00 00       	mov    $0x400,%ecx
  401c9b:	b8 00 00 00 00       	mov    $0x0,%eax
  401ca0:	48 89 d7             	mov    %rdx,%rdi
  401ca3:	f3 48 ab             	rep stos %rax,%es:(%rdi)
  401ca6:	48 c7 c1 ff ff ff ff 	mov    $0xffffffffffffffff,%rcx
  401cad:	48 89 df             	mov    %rbx,%rdi
  401cb0:	f2 ae                	repnz scas %es:(%rdi),%al
  401cb2:	48 89 c8             	mov    %rcx,%rax
  401cb5:	48 f7 d0             	not    %rax
  401cb8:	48 83 e8 01          	sub    $0x1,%rax
  401cbc:	85 c0                	test   %eax,%eax
  401cbe:	0f 84 90 04 00 00    	je     402154 <submitr+0x777>
  401cc4:	8d 40 ff             	lea    -0x1(%rax),%eax
  401cc7:	4c 8d 74 03 01       	lea    0x1(%rbx,%rax,1),%r14
  401ccc:	48 89 d5             	mov    %rdx,%rbp
  401ccf:	49 bd d9 ff 00 00 00 	movabs $0x2000000000ffd9,%r13
  401cd6:	00 20 00 
  401cd9:	44 0f b6 03          	movzbl (%rbx),%r8d
  401cdd:	41 8d 40 d6          	lea    -0x2a(%r8),%eax
  401ce1:	3c 35                	cmp    $0x35,%al
  401ce3:	77 06                	ja     401ceb <submitr+0x30e>
  401ce5:	49 0f a3 c5          	bt     %rax,%r13
  401ce9:	72 0d                	jb     401cf8 <submitr+0x31b>
  401ceb:	44 89 c0             	mov    %r8d,%eax
  401cee:	83 e0 df             	and    $0xffffffdf,%eax
  401cf1:	83 e8 41             	sub    $0x41,%eax
  401cf4:	3c 19                	cmp    $0x19,%al
  401cf6:	77 0a                	ja     401d02 <submitr+0x325>
  401cf8:	44 88 45 00          	mov    %r8b,0x0(%rbp)
  401cfc:	48 8d 6d 01          	lea    0x1(%rbp),%rbp
  401d00:	eb 6c                	jmp    401d6e <submitr+0x391>
  401d02:	41 80 f8 20          	cmp    $0x20,%r8b
  401d06:	75 0a                	jne    401d12 <submitr+0x335>
  401d08:	c6 45 00 2b          	movb   $0x2b,0x0(%rbp)
  401d0c:	48 8d 6d 01          	lea    0x1(%rbp),%rbp
  401d10:	eb 5c                	jmp    401d6e <submitr+0x391>
  401d12:	41 8d 40 e0          	lea    -0x20(%r8),%eax
  401d16:	3c 5f                	cmp    $0x5f,%al
  401d18:	76 0a                	jbe    401d24 <submitr+0x347>
  401d1a:	41 80 f8 09          	cmp    $0x9,%r8b
  401d1e:	0f 85 a3 03 00 00    	jne    4020c7 <submitr+0x6ea>
  401d24:	45 0f b6 c0          	movzbl %r8b,%r8d
  401d28:	b9 20 2b 40 00       	mov    $0x402b20,%ecx
  401d2d:	ba 08 00 00 00       	mov    $0x8,%edx
  401d32:	be 01 00 00 00       	mov    $0x1,%esi
  401d37:	48 8d bc 24 50 80 00 	lea    0x8050(%rsp),%rdi
  401d3e:	00 
  401d3f:	b8 00 00 00 00       	mov    $0x0,%eax
  401d44:	e8 87 ef ff ff       	callq  400cd0 <__sprintf_chk@plt>
  401d49:	0f b6 84 24 50 80 00 	movzbl 0x8050(%rsp),%eax
  401d50:	00 
  401d51:	88 45 00             	mov    %al,0x0(%rbp)
  401d54:	0f b6 84 24 51 80 00 	movzbl 0x8051(%rsp),%eax
  401d5b:	00 
  401d5c:	88 45 01             	mov    %al,0x1(%rbp)
  401d5f:	0f b6 84 24 52 80 00 	movzbl 0x8052(%rsp),%eax
  401d66:	00 
  401d67:	88 45 02             	mov    %al,0x2(%rbp)
  401d6a:	48 8d 6d 03          	lea    0x3(%rbp),%rbp
  401d6e:	48 83 c3 01          	add    $0x1,%rbx
  401d72:	49 39 de             	cmp    %rbx,%r14
  401d75:	0f 85 5e ff ff ff    	jne    401cd9 <submitr+0x2fc>
  401d7b:	e9 d4 03 00 00       	jmpq   402154 <submitr+0x777>
  401d80:	48 89 da             	mov    %rbx,%rdx
  401d83:	48 89 ee             	mov    %rbp,%rsi
  401d86:	44 89 e7             	mov    %r12d,%edi
  401d89:	e8 f2 ed ff ff       	callq  400b80 <write@plt>
  401d8e:	48 85 c0             	test   %rax,%rax
  401d91:	7f 0f                	jg     401da2 <submitr+0x3c5>
  401d93:	e8 b8 ed ff ff       	callq  400b50 <__errno_location@plt>
  401d98:	83 38 04             	cmpl   $0x4,(%rax)
  401d9b:	75 12                	jne    401daf <submitr+0x3d2>
  401d9d:	b8 00 00 00 00       	mov    $0x0,%eax
  401da2:	48 01 c5             	add    %rax,%rbp
  401da5:	48 29 c3             	sub    %rax,%rbx
  401da8:	75 d6                	jne    401d80 <submitr+0x3a3>
  401daa:	4d 85 ed             	test   %r13,%r13
  401dad:	79 5f                	jns    401e0e <submitr+0x431>
  401daf:	48 b8 45 72 72 6f 72 	movabs $0x43203a726f727245,%rax
  401db6:	3a 20 43 
  401db9:	49 89 07             	mov    %rax,(%r15)
  401dbc:	48 b8 6c 69 65 6e 74 	movabs $0x6e7520746e65696c,%rax
  401dc3:	20 75 6e 
  401dc6:	49 89 47 08          	mov    %rax,0x8(%r15)
  401dca:	48 b8 61 62 6c 65 20 	movabs $0x206f7420656c6261,%rax
  401dd1:	74 6f 20 
  401dd4:	49 89 47 10          	mov    %rax,0x10(%r15)
  401dd8:	48 b8 77 72 69 74 65 	movabs $0x6f74206574697277,%rax
  401ddf:	20 74 6f 
  401de2:	49 89 47 18          	mov    %rax,0x18(%r15)
  401de6:	48 b8 20 74 68 65 20 	movabs $0x7265732065687420,%rax
  401ded:	73 65 72 
  401df0:	49 89 47 20          	mov    %rax,0x20(%r15)
  401df4:	41 c7 47 28 76 65 72 	movl   $0x726576,0x28(%r15)
  401dfb:	00 
  401dfc:	44 89 e7             	mov    %r12d,%edi
  401dff:	e8 ac ed ff ff       	callq  400bb0 <close@plt>
  401e04:	b8 ff ff ff ff       	mov    $0xffffffff,%eax
  401e09:	e9 9d 02 00 00       	jmpq   4020ab <submitr+0x6ce>
  401e0e:	44 89 64 24 40       	mov    %r12d,0x40(%rsp)
  401e13:	c7 44 24 44 00 00 00 	movl   $0x0,0x44(%rsp)
  401e1a:	00 
  401e1b:	48 8d 44 24 50       	lea    0x50(%rsp),%rax
  401e20:	48 89 44 24 48       	mov    %rax,0x48(%rsp)
  401e25:	ba 00 20 00 00       	mov    $0x2000,%edx
  401e2a:	48 8d b4 24 50 20 00 	lea    0x2050(%rsp),%rsi
  401e31:	00 
  401e32:	48 8d 7c 24 40       	lea    0x40(%rsp),%rdi
  401e37:	e8 af fa ff ff       	callq  4018eb <rio_readlineb>
  401e3c:	48 85 c0             	test   %rax,%rax
  401e3f:	7f 74                	jg     401eb5 <submitr+0x4d8>
  401e41:	48 b8 45 72 72 6f 72 	movabs $0x43203a726f727245,%rax
  401e48:	3a 20 43 
  401e4b:	49 89 07             	mov    %rax,(%r15)
  401e4e:	48 b8 6c 69 65 6e 74 	movabs $0x6e7520746e65696c,%rax
  401e55:	20 75 6e 
  401e58:	49 89 47 08          	mov    %rax,0x8(%r15)
  401e5c:	48 b8 61 62 6c 65 20 	movabs $0x206f7420656c6261,%rax
  401e63:	74 6f 20 
  401e66:	49 89 47 10          	mov    %rax,0x10(%r15)
  401e6a:	48 b8 72 65 61 64 20 	movabs $0x7269662064616572,%rax
  401e71:	66 69 72 
  401e74:	49 89 47 18          	mov    %rax,0x18(%r15)
  401e78:	48 b8 73 74 20 68 65 	movabs $0x6564616568207473,%rax
  401e7f:	61 64 65 
  401e82:	49 89 47 20          	mov    %rax,0x20(%r15)
  401e86:	48 b8 72 20 66 72 6f 	movabs $0x73206d6f72662072,%rax
  401e8d:	6d 20 73 
  401e90:	49 89 47 28          	mov    %rax,0x28(%r15)
  401e94:	41 c7 47 30 65 72 76 	movl   $0x65767265,0x30(%r15)
  401e9b:	65 
  401e9c:	66 41 c7 47 34 72 00 	movw   $0x72,0x34(%r15)
  401ea3:	44 89 e7             	mov    %r12d,%edi
  401ea6:	e8 05 ed ff ff       	callq  400bb0 <close@plt>
  401eab:	b8 ff ff ff ff       	mov    $0xffffffff,%eax
  401eb0:	e9 f6 01 00 00       	jmpq   4020ab <submitr+0x6ce>
  401eb5:	4c 8d 84 24 50 80 00 	lea    0x8050(%rsp),%r8
  401ebc:	00 
  401ebd:	48 8d 4c 24 2c       	lea    0x2c(%rsp),%rcx
  401ec2:	48 8d 94 24 50 60 00 	lea    0x6050(%rsp),%rdx
  401ec9:	00 
  401eca:	be 27 2b 40 00       	mov    $0x402b27,%esi
  401ecf:	48 8d bc 24 50 20 00 	lea    0x2050(%rsp),%rdi
  401ed6:	00 
  401ed7:	b8 00 00 00 00       	mov    $0x0,%eax
  401edc:	e8 5f ed ff ff       	callq  400c40 <__isoc99_sscanf@plt>
  401ee1:	44 8b 44 24 2c       	mov    0x2c(%rsp),%r8d
  401ee6:	41 81 f8 c8 00 00 00 	cmp    $0xc8,%r8d
  401eed:	0f 84 be 00 00 00    	je     401fb1 <submitr+0x5d4>
  401ef3:	4c 8d 8c 24 50 80 00 	lea    0x8050(%rsp),%r9
  401efa:	00 
  401efb:	b9 70 2a 40 00       	mov    $0x402a70,%ecx
  401f00:	48 c7 c2 ff ff ff ff 	mov    $0xffffffffffffffff,%rdx
  401f07:	be 01 00 00 00       	mov    $0x1,%esi
  401f0c:	4c 89 ff             	mov    %r15,%rdi
  401f0f:	b8 00 00 00 00       	mov    $0x0,%eax
  401f14:	e8 b7 ed ff ff       	callq  400cd0 <__sprintf_chk@plt>
  401f19:	44 89 e7             	mov    %r12d,%edi
  401f1c:	e8 8f ec ff ff       	callq  400bb0 <close@plt>
  401f21:	b8 ff ff ff ff       	mov    $0xffffffff,%eax
  401f26:	e9 80 01 00 00       	jmpq   4020ab <submitr+0x6ce>
  401f2b:	ba 00 20 00 00       	mov    $0x2000,%edx
  401f30:	48 8d b4 24 50 20 00 	lea    0x2050(%rsp),%rsi
  401f37:	00 
  401f38:	48 8d 7c 24 40       	lea    0x40(%rsp),%rdi
  401f3d:	e8 a9 f9 ff ff       	callq  4018eb <rio_readlineb>
  401f42:	48 85 c0             	test   %rax,%rax
  401f45:	7f 6a                	jg     401fb1 <submitr+0x5d4>
  401f47:	48 b8 45 72 72 6f 72 	movabs $0x43203a726f727245,%rax
  401f4e:	3a 20 43 
  401f51:	49 89 07             	mov    %rax,(%r15)
  401f54:	48 b8 6c 69 65 6e 74 	movabs $0x6e7520746e65696c,%rax
  401f5b:	20 75 6e 
  401f5e:	49 89 47 08          	mov    %rax,0x8(%r15)
  401f62:	48 b8 61 62 6c 65 20 	movabs $0x206f7420656c6261,%rax
  401f69:	74 6f 20 
  401f6c:	49 89 47 10          	mov    %rax,0x10(%r15)
  401f70:	48 b8 72 65 61 64 20 	movabs $0x6165682064616572,%rax
  401f77:	68 65 61 
  401f7a:	49 89 47 18          	mov    %rax,0x18(%r15)
  401f7e:	48 b8 64 65 72 73 20 	movabs $0x6f72662073726564,%rax
  401f85:	66 72 6f 
  401f88:	49 89 47 20          	mov    %rax,0x20(%r15)
  401f8c:	48 b8 6d 20 73 65 72 	movabs $0x726576726573206d,%rax
  401f93:	76 65 72 
  401f96:	49 89 47 28          	mov    %rax,0x28(%r15)
  401f9a:	41 c6 47 30 00       	movb   $0x0,0x30(%r15)
  401f9f:	44 89 e7             	mov    %r12d,%edi
  401fa2:	e8 09 ec ff ff       	callq  400bb0 <close@plt>
  401fa7:	b8 ff ff ff ff       	mov    $0xffffffff,%eax
  401fac:	e9 fa 00 00 00       	jmpq   4020ab <submitr+0x6ce>
  401fb1:	80 bc 24 50 20 00 00 	cmpb   $0xd,0x2050(%rsp)
  401fb8:	0d 
  401fb9:	0f 85 6c ff ff ff    	jne    401f2b <submitr+0x54e>
  401fbf:	80 bc 24 51 20 00 00 	cmpb   $0xa,0x2051(%rsp)
  401fc6:	0a 
  401fc7:	0f 85 5e ff ff ff    	jne    401f2b <submitr+0x54e>
  401fcd:	80 bc 24 52 20 00 00 	cmpb   $0x0,0x2052(%rsp)
  401fd4:	00 
  401fd5:	0f 85 50 ff ff ff    	jne    401f2b <submitr+0x54e>
  401fdb:	ba 00 20 00 00       	mov    $0x2000,%edx
  401fe0:	48 8d b4 24 50 20 00 	lea    0x2050(%rsp),%rsi
  401fe7:	00 
  401fe8:	48 8d 7c 24 40       	lea    0x40(%rsp),%rdi
  401fed:	e8 f9 f8 ff ff       	callq  4018eb <rio_readlineb>
  401ff2:	48 85 c0             	test   %rax,%rax
  401ff5:	7f 70                	jg     402067 <submitr+0x68a>
  401ff7:	48 b8 45 72 72 6f 72 	movabs $0x43203a726f727245,%rax
  401ffe:	3a 20 43 
  402001:	49 89 07             	mov    %rax,(%r15)
  402004:	48 b8 6c 69 65 6e 74 	movabs $0x6e7520746e65696c,%rax
  40200b:	20 75 6e 
  40200e:	49 89 47 08          	mov    %rax,0x8(%r15)
  402012:	48 b8 61 62 6c 65 20 	movabs $0x206f7420656c6261,%rax
  402019:	74 6f 20 
  40201c:	49 89 47 10          	mov    %rax,0x10(%r15)
  402020:	48 b8 72 65 61 64 20 	movabs $0x6174732064616572,%rax
  402027:	73 74 61 
  40202a:	49 89 47 18          	mov    %rax,0x18(%r15)
  40202e:	48 b8 74 75 73 20 6d 	movabs $0x7373656d20737574,%rax
  402035:	65 73 73 
  402038:	49 89 47 20          	mov    %rax,0x20(%r15)
  40203c:	48 b8 61 67 65 20 66 	movabs $0x6d6f726620656761,%rax
  402043:	72 6f 6d 
  402046:	49 89 47 28          	mov    %rax,0x28(%r15)
  40204a:	48 b8 20 73 65 72 76 	movabs $0x72657672657320,%rax
  402051:	65 72 00 
  402054:	49 89 47 30          	mov    %rax,0x30(%r15)
  402058:	44 89 e7             	mov    %r12d,%edi
  40205b:	e8 50 eb ff ff       	callq  400bb0 <close@plt>
  402060:	b8 ff ff ff ff       	mov    $0xffffffff,%eax
  402065:	eb 44                	jmp    4020ab <submitr+0x6ce>
  402067:	48 8d b4 24 50 20 00 	lea    0x2050(%rsp),%rsi
  40206e:	00 
  40206f:	4c 89 ff             	mov    %r15,%rdi
  402072:	e8 e9 ea ff ff       	callq  400b60 <strcpy@plt>
  402077:	44 89 e7             	mov    %r12d,%edi
  40207a:	e8 31 eb ff ff       	callq  400bb0 <close@plt>
  40207f:	41 0f b6 17          	movzbl (%r15),%edx
  402083:	b8 4f 00 00 00       	mov    $0x4f,%eax
  402088:	29 d0                	sub    %edx,%eax
  40208a:	75 15                	jne    4020a1 <submitr+0x6c4>
  40208c:	41 0f b6 57 01       	movzbl 0x1(%r15),%edx
  402091:	b8 4b 00 00 00       	mov    $0x4b,%eax
  402096:	29 d0                	sub    %edx,%eax
  402098:	75 07                	jne    4020a1 <submitr+0x6c4>
  40209a:	41 0f b6 47 02       	movzbl 0x2(%r15),%eax
  40209f:	f7 d8                	neg    %eax
  4020a1:	85 c0                	test   %eax,%eax
  4020a3:	0f 95 c0             	setne  %al
  4020a6:	0f b6 c0             	movzbl %al,%eax
  4020a9:	f7 d8                	neg    %eax
  4020ab:	48 8b 8c 24 58 a0 00 	mov    0xa058(%rsp),%rcx
  4020b2:	00 
  4020b3:	64 48 33 0c 25 28 00 	xor    %fs:0x28,%rcx
  4020ba:	00 00 
  4020bc:	0f 84 12 01 00 00    	je     4021d4 <submitr+0x7f7>
  4020c2:	e9 08 01 00 00       	jmpq   4021cf <submitr+0x7f2>
  4020c7:	48 b8 45 72 72 6f 72 	movabs $0x52203a726f727245,%rax
  4020ce:	3a 20 52 
  4020d1:	49 89 07             	mov    %rax,(%r15)
  4020d4:	48 b8 65 73 75 6c 74 	movabs $0x747320746c757365,%rax
  4020db:	20 73 74 
  4020de:	49 89 47 08          	mov    %rax,0x8(%r15)
  4020e2:	48 b8 72 69 6e 67 20 	movabs $0x6e6f6320676e6972,%rax
  4020e9:	63 6f 6e 
  4020ec:	49 89 47 10          	mov    %rax,0x10(%r15)
  4020f0:	48 b8 74 61 69 6e 73 	movabs $0x6e6120736e696174,%rax
  4020f7:	20 61 6e 
  4020fa:	49 89 47 18          	mov    %rax,0x18(%r15)
  4020fe:	48 b8 20 69 6c 6c 65 	movabs $0x6c6167656c6c6920,%rax
  402105:	67 61 6c 
  402108:	49 89 47 20          	mov    %rax,0x20(%r15)
  40210c:	48 b8 20 6f 72 20 75 	movabs $0x72706e7520726f20,%rax
  402113:	6e 70 72 
  402116:	49 89 47 28          	mov    %rax,0x28(%r15)
  40211a:	48 b8 69 6e 74 61 62 	movabs $0x20656c6261746e69,%rax
  402121:	6c 65 20 
  402124:	49 89 47 30          	mov    %rax,0x30(%r15)
  402128:	48 b8 63 68 61 72 61 	movabs $0x6574636172616863,%rax
  40212f:	63 74 65 
  402132:	49 89 47 38          	mov    %rax,0x38(%r15)
  402136:	66 41 c7 47 40 72 2e 	movw   $0x2e72,0x40(%r15)
  40213d:	41 c6 47 42 00       	movb   $0x0,0x42(%r15)
  402142:	44 89 e7             	mov    %r12d,%edi
  402145:	e8 66 ea ff ff       	callq  400bb0 <close@plt>
  40214a:	b8 ff ff ff ff       	mov    $0xffffffff,%eax
  40214f:	e9 57 ff ff ff       	jmpq   4020ab <submitr+0x6ce>
  402154:	48 8d 9c 24 50 20 00 	lea    0x2050(%rsp),%rbx
  40215b:	00 
  40215c:	48 83 ec 08          	sub    $0x8,%rsp
  402160:	48 8d 84 24 58 40 00 	lea    0x4058(%rsp),%rax
  402167:	00 
  402168:	50                   	push   %rax
  402169:	ff 74 24 20          	pushq  0x20(%rsp)
  40216d:	ff 74 24 30          	pushq  0x30(%rsp)
  402171:	4c 8b 4c 24 28       	mov    0x28(%rsp),%r9
  402176:	4c 8b 44 24 20       	mov    0x20(%rsp),%r8
  40217b:	b9 a0 2a 40 00       	mov    $0x402aa0,%ecx
  402180:	ba 00 20 00 00       	mov    $0x2000,%edx
  402185:	be 01 00 00 00       	mov    $0x1,%esi
  40218a:	48 89 df             	mov    %rbx,%rdi
  40218d:	b8 00 00 00 00       	mov    $0x0,%eax
  402192:	e8 39 eb ff ff       	callq  400cd0 <__sprintf_chk@plt>
  402197:	b8 00 00 00 00       	mov    $0x0,%eax
  40219c:	48 c7 c1 ff ff ff ff 	mov    $0xffffffffffffffff,%rcx
  4021a3:	48 89 df             	mov    %rbx,%rdi
  4021a6:	f2 ae                	repnz scas %es:(%rdi),%al
  4021a8:	48 89 c8             	mov    %rcx,%rax
  4021ab:	48 f7 d0             	not    %rax
  4021ae:	4c 8d 68 ff          	lea    -0x1(%rax),%r13
  4021b2:	48 83 c4 20          	add    $0x20,%rsp
  4021b6:	4c 89 eb             	mov    %r13,%rbx
  4021b9:	48 8d ac 24 50 20 00 	lea    0x2050(%rsp),%rbp
  4021c0:	00 
  4021c1:	4d 85 ed             	test   %r13,%r13
  4021c4:	0f 85 b6 fb ff ff    	jne    401d80 <submitr+0x3a3>
  4021ca:	e9 3f fc ff ff       	jmpq   401e0e <submitr+0x431>
  4021cf:	e8 bc e9 ff ff       	callq  400b90 <__stack_chk_fail@plt>
  4021d4:	48 81 c4 68 a0 00 00 	add    $0xa068,%rsp
  4021db:	5b                   	pop    %rbx
  4021dc:	5d                   	pop    %rbp
  4021dd:	41 5c                	pop    %r12
  4021df:	41 5d                	pop    %r13
  4021e1:	41 5e                	pop    %r14
  4021e3:	41 5f                	pop    %r15
  4021e5:	c3                   	retq   

00000000004021e6 <init_timeout>:
  4021e6:	85 ff                	test   %edi,%edi
  4021e8:	74 22                	je     40220c <init_timeout+0x26>
  4021ea:	53                   	push   %rbx
  4021eb:	89 fb                	mov    %edi,%ebx
  4021ed:	be bd 18 40 00       	mov    $0x4018bd,%esi
  4021f2:	bf 0e 00 00 00       	mov    $0xe,%edi
  4021f7:	e8 f4 e9 ff ff       	callq  400bf0 <signal@plt>
  4021fc:	85 db                	test   %ebx,%ebx
  4021fe:	bf 00 00 00 00       	mov    $0x0,%edi
  402203:	0f 49 fb             	cmovns %ebx,%edi
  402206:	e8 95 e9 ff ff       	callq  400ba0 <alarm@plt>
  40220b:	5b                   	pop    %rbx
  40220c:	f3 c3                	repz retq 

000000000040220e <init_driver>:
  40220e:	55                   	push   %rbp
  40220f:	53                   	push   %rbx
  402210:	48 83 ec 28          	sub    $0x28,%rsp
  402214:	48 89 fd             	mov    %rdi,%rbp
  402217:	64 48 8b 04 25 28 00 	mov    %fs:0x28,%rax
  40221e:	00 00 
  402220:	48 89 44 24 18       	mov    %rax,0x18(%rsp)
  402225:	31 c0                	xor    %eax,%eax
  402227:	be 01 00 00 00       	mov    $0x1,%esi
  40222c:	bf 0d 00 00 00       	mov    $0xd,%edi
  402231:	e8 ba e9 ff ff       	callq  400bf0 <signal@plt>
  402236:	be 01 00 00 00       	mov    $0x1,%esi
  40223b:	bf 1d 00 00 00       	mov    $0x1d,%edi
  402240:	e8 ab e9 ff ff       	callq  400bf0 <signal@plt>
  402245:	be 01 00 00 00       	mov    $0x1,%esi
  40224a:	bf 1d 00 00 00       	mov    $0x1d,%edi
  40224f:	e8 9c e9 ff ff       	callq  400bf0 <signal@plt>
  402254:	ba 00 00 00 00       	mov    $0x0,%edx
  402259:	be 01 00 00 00       	mov    $0x1,%esi
  40225e:	bf 02 00 00 00       	mov    $0x2,%edi
  402263:	e8 78 ea ff ff       	callq  400ce0 <socket@plt>
  402268:	85 c0                	test   %eax,%eax
  40226a:	79 4f                	jns    4022bb <init_driver+0xad>
  40226c:	48 b8 45 72 72 6f 72 	movabs $0x43203a726f727245,%rax
  402273:	3a 20 43 
  402276:	48 89 45 00          	mov    %rax,0x0(%rbp)
  40227a:	48 b8 6c 69 65 6e 74 	movabs $0x6e7520746e65696c,%rax
  402281:	20 75 6e 
  402284:	48 89 45 08          	mov    %rax,0x8(%rbp)
  402288:	48 b8 61 62 6c 65 20 	movabs $0x206f7420656c6261,%rax
  40228f:	74 6f 20 
  402292:	48 89 45 10          	mov    %rax,0x10(%rbp)
  402296:	48 b8 63 72 65 61 74 	movabs $0x7320657461657263,%rax
  40229d:	65 20 73 
  4022a0:	48 89 45 18          	mov    %rax,0x18(%rbp)
  4022a4:	c7 45 20 6f 63 6b 65 	movl   $0x656b636f,0x20(%rbp)
  4022ab:	66 c7 45 24 74 00    	movw   $0x74,0x24(%rbp)
  4022b1:	b8 ff ff ff ff       	mov    $0xffffffff,%eax
  4022b6:	e9 0c 01 00 00       	jmpq   4023c7 <init_driver+0x1b9>
  4022bb:	89 c3                	mov    %eax,%ebx
  4022bd:	bf 2e 2a 40 00       	mov    $0x402a2e,%edi
  4022c2:	e8 39 e9 ff ff       	callq  400c00 <gethostbyname@plt>
  4022c7:	48 85 c0             	test   %rax,%rax
  4022ca:	75 68                	jne    402334 <init_driver+0x126>
  4022cc:	48 b8 45 72 72 6f 72 	movabs $0x44203a726f727245,%rax
  4022d3:	3a 20 44 
  4022d6:	48 89 45 00          	mov    %rax,0x0(%rbp)
  4022da:	48 b8 4e 53 20 69 73 	movabs $0x6e7520736920534e,%rax
  4022e1:	20 75 6e 
  4022e4:	48 89 45 08          	mov    %rax,0x8(%rbp)
  4022e8:	48 b8 61 62 6c 65 20 	movabs $0x206f7420656c6261,%rax
  4022ef:	74 6f 20 
  4022f2:	48 89 45 10          	mov    %rax,0x10(%rbp)
  4022f6:	48 b8 72 65 73 6f 6c 	movabs $0x2065766c6f736572,%rax
  4022fd:	76 65 20 
  402300:	48 89 45 18          	mov    %rax,0x18(%rbp)
  402304:	48 b8 73 65 72 76 65 	movabs $0x6120726576726573,%rax
  40230b:	72 20 61 
  40230e:	48 89 45 20          	mov    %rax,0x20(%rbp)
  402312:	c7 45 28 64 64 72 65 	movl   $0x65726464,0x28(%rbp)
  402319:	66 c7 45 2c 73 73    	movw   $0x7373,0x2c(%rbp)
  40231f:	c6 45 2e 00          	movb   $0x0,0x2e(%rbp)
  402323:	89 df                	mov    %ebx,%edi
  402325:	e8 86 e8 ff ff       	callq  400bb0 <close@plt>
  40232a:	b8 ff ff ff ff       	mov    $0xffffffff,%eax
  40232f:	e9 93 00 00 00       	jmpq   4023c7 <init_driver+0x1b9>
  402334:	48 c7 04 24 00 00 00 	movq   $0x0,(%rsp)
  40233b:	00 
  40233c:	48 c7 44 24 08 00 00 	movq   $0x0,0x8(%rsp)
  402343:	00 00 
  402345:	66 c7 04 24 02 00    	movw   $0x2,(%rsp)
  40234b:	48 63 50 14          	movslq 0x14(%rax),%rdx
  40234f:	48 8b 40 18          	mov    0x18(%rax),%rax
  402353:	48 8d 7c 24 04       	lea    0x4(%rsp),%rdi
  402358:	b9 0c 00 00 00       	mov    $0xc,%ecx
  40235d:	48 8b 30             	mov    (%rax),%rsi
  402360:	e8 ab e8 ff ff       	callq  400c10 <__memmove_chk@plt>
  402365:	66 c7 44 24 02 27 11 	movw   $0x1127,0x2(%rsp)
  40236c:	ba 10 00 00 00       	mov    $0x10,%edx
  402371:	48 89 e6             	mov    %rsp,%rsi
  402374:	89 df                	mov    %ebx,%edi
  402376:	e8 15 e9 ff ff       	callq  400c90 <connect@plt>
  40237b:	85 c0                	test   %eax,%eax
  40237d:	79 32                	jns    4023b1 <init_driver+0x1a3>
  40237f:	41 b8 2e 2a 40 00    	mov    $0x402a2e,%r8d
  402385:	b9 f8 2a 40 00       	mov    $0x402af8,%ecx
  40238a:	48 c7 c2 ff ff ff ff 	mov    $0xffffffffffffffff,%rdx
  402391:	be 01 00 00 00       	mov    $0x1,%esi
  402396:	48 89 ef             	mov    %rbp,%rdi
  402399:	b8 00 00 00 00       	mov    $0x0,%eax
  40239e:	e8 2d e9 ff ff       	callq  400cd0 <__sprintf_chk@plt>
  4023a3:	89 df                	mov    %ebx,%edi
  4023a5:	e8 06 e8 ff ff       	callq  400bb0 <close@plt>
  4023aa:	b8 ff ff ff ff       	mov    $0xffffffff,%eax
  4023af:	eb 16                	jmp    4023c7 <init_driver+0x1b9>
  4023b1:	89 df                	mov    %ebx,%edi
  4023b3:	e8 f8 e7 ff ff       	callq  400bb0 <close@plt>
  4023b8:	66 c7 45 00 4f 4b    	movw   $0x4b4f,0x0(%rbp)
  4023be:	c6 45 02 00          	movb   $0x0,0x2(%rbp)
  4023c2:	b8 00 00 00 00       	mov    $0x0,%eax
  4023c7:	48 8b 4c 24 18       	mov    0x18(%rsp),%rcx
  4023cc:	64 48 33 0c 25 28 00 	xor    %fs:0x28,%rcx
  4023d3:	00 00 
  4023d5:	74 05                	je     4023dc <init_driver+0x1ce>
  4023d7:	e8 b4 e7 ff ff       	callq  400b90 <__stack_chk_fail@plt>
  4023dc:	48 83 c4 28          	add    $0x28,%rsp
  4023e0:	5b                   	pop    %rbx
  4023e1:	5d                   	pop    %rbp
  4023e2:	c3                   	retq   

00000000004023e3 <driver_post>:
  4023e3:	53                   	push   %rbx
  4023e4:	4c 89 c3             	mov    %r8,%rbx
  4023e7:	85 c9                	test   %ecx,%ecx
  4023e9:	74 24                	je     40240f <driver_post+0x2c>
  4023eb:	be 38 2b 40 00       	mov    $0x402b38,%esi
  4023f0:	bf 01 00 00 00       	mov    $0x1,%edi
  4023f5:	b8 00 00 00 00       	mov    $0x0,%eax
  4023fa:	e8 51 e8 ff ff       	callq  400c50 <__printf_chk@plt>
  4023ff:	66 c7 03 4f 4b       	movw   $0x4b4f,(%rbx)
  402404:	c6 43 02 00          	movb   $0x0,0x2(%rbx)
  402408:	b8 00 00 00 00       	mov    $0x0,%eax
  40240d:	eb 41                	jmp    402450 <driver_post+0x6d>
  40240f:	48 85 ff             	test   %rdi,%rdi
  402412:	74 2e                	je     402442 <driver_post+0x5f>
  402414:	80 3f 00             	cmpb   $0x0,(%rdi)
  402417:	74 29                	je     402442 <driver_post+0x5f>
  402419:	41 50                	push   %r8
  40241b:	52                   	push   %rdx
  40241c:	41 b9 4f 2b 40 00    	mov    $0x402b4f,%r9d
  402422:	49 89 f0             	mov    %rsi,%r8
  402425:	48 89 f9             	mov    %rdi,%rcx
  402428:	ba 55 2b 40 00       	mov    $0x402b55,%edx
  40242d:	be 11 27 00 00       	mov    $0x2711,%esi
  402432:	bf 2e 2a 40 00       	mov    $0x402a2e,%edi
  402437:	e8 a1 f5 ff ff       	callq  4019dd <submitr>
  40243c:	48 83 c4 10          	add    $0x10,%rsp
  402440:	eb 0e                	jmp    402450 <driver_post+0x6d>
  402442:	66 c7 03 4f 4b       	movw   $0x4b4f,(%rbx)
  402447:	c6 43 02 00          	movb   $0x0,0x2(%rbx)
  40244b:	b8 00 00 00 00       	mov    $0x0,%eax
  402450:	5b                   	pop    %rbx
  402451:	c3                   	retq   
  402452:	66 2e 0f 1f 84 00 00 	nopw   %cs:0x0(%rax,%rax,1)
  402459:	00 00 00 
  40245c:	0f 1f 40 00          	nopl   0x0(%rax)

0000000000402460 <__libc_csu_init>:
  402460:	41 57                	push   %r15
  402462:	41 56                	push   %r14
  402464:	41 89 ff             	mov    %edi,%r15d
  402467:	41 55                	push   %r13
  402469:	41 54                	push   %r12
  40246b:	4c 8d 25 9e 19 20 00 	lea    0x20199e(%rip),%r12        # 603e10 <__frame_dummy_init_array_entry>
  402472:	55                   	push   %rbp
  402473:	48 8d 2d 9e 19 20 00 	lea    0x20199e(%rip),%rbp        # 603e18 <__init_array_end>
  40247a:	53                   	push   %rbx
  40247b:	49 89 f6             	mov    %rsi,%r14
  40247e:	49 89 d5             	mov    %rdx,%r13
  402481:	4c 29 e5             	sub    %r12,%rbp
  402484:	48 83 ec 08          	sub    $0x8,%rsp
  402488:	48 c1 fd 03          	sar    $0x3,%rbp
  40248c:	e8 6f e6 ff ff       	callq  400b00 <_init>
  402491:	48 85 ed             	test   %rbp,%rbp
  402494:	74 20                	je     4024b6 <__libc_csu_init+0x56>
  402496:	31 db                	xor    %ebx,%ebx
  402498:	0f 1f 84 00 00 00 00 	nopl   0x0(%rax,%rax,1)
  40249f:	00 
  4024a0:	4c 89 ea             	mov    %r13,%rdx
  4024a3:	4c 89 f6             	mov    %r14,%rsi
  4024a6:	44 89 ff             	mov    %r15d,%edi
  4024a9:	41 ff 14 dc          	callq  *(%r12,%rbx,8)
  4024ad:	48 83 c3 01          	add    $0x1,%rbx
  4024b1:	48 39 eb             	cmp    %rbp,%rbx
  4024b4:	75 ea                	jne    4024a0 <__libc_csu_init+0x40>
  4024b6:	48 83 c4 08          	add    $0x8,%rsp
  4024ba:	5b                   	pop    %rbx
  4024bb:	5d                   	pop    %rbp
  4024bc:	41 5c                	pop    %r12
  4024be:	41 5d                	pop    %r13
  4024c0:	41 5e                	pop    %r14
  4024c2:	41 5f                	pop    %r15
  4024c4:	c3                   	retq   
  4024c5:	90                   	nop
  4024c6:	66 2e 0f 1f 84 00 00 	nopw   %cs:0x0(%rax,%rax,1)
  4024cd:	00 00 00 

00000000004024d0 <__libc_csu_fini>:
  4024d0:	f3 c3                	repz retq 

Disassembly of section .fini:

00000000004024d4 <_fini>:
  4024d4:	48 83 ec 08          	sub    $0x8,%rsp
  4024d8:	48 83 c4 08          	add    $0x8,%rsp
  4024dc:	c3                   	retq   
