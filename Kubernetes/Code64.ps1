param([string]$input)
[System.Console]::WriteLine("Hola")
[System.Console]::WriteLine("Input: " + $input)
$result = [Convert]::ToBase64String([System.Text.Encoding]::UTF8.GetBytes($input))
[System.Console]::WriteLine("Resultado: " + $result)