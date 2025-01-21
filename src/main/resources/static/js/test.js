        // 유효성 검사 스크립트

        const input_name = document.getElementById('item_id');
        const form = document.getElementById('itemForm');

        //공백 검사
        function hasWhiteSpace(str){
            return /\s/.test(str);
        }

        //특수 문자
        // ., -, \, [, ] 는 정규식에 사용되는 문자이므로 이스케이프 처리를 해야 한다. (예시) \. << 특수문자 앞에 역슬래시 넣기
        function hasSpecialChar(str){
            return /[!@#$%^&*():{}|<>,\.'~_=?/+\-\\`\[\]]/.test(str);
        }

        //숫자로 시작하는지 검사
        function startWithNumber(str){
            return /^[0-9]/.test(str);
        }

        input_name.addEventListener('input', function(e){
            const value = e.target.value;
            const spaceError = document.getElementById('spaceError');
            const specialCharError = document.getElementById('specialCharError');
            const startWithNumberError = document.getElementById('startWithNumber');
            // console.log(value, "=>", " hasWhiteSpace(value));
            spaceError.style.display = hasWhiteSpace(value) ? 'block' : 'none';
            specialCharError.style.display = hasSpecialChar(value) ? 'block' : 'none';
            startWithNumberError.style.display = startWithNumber(value) ? 'block' : 'none';
        })


        form.addEventListener('submit', function(e){
            e.preventDefault();
            const value = input_name.value;
            if(! hasWhiteSpace(value) && ! hasSpecialChar(value) && ! startWithNumber(value)){
                alert('서버로 전송 성공.');
            }else{
                alert('입력값을 다시 확인해 주세요.');
            }
        })